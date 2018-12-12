package cn.liberfree.mybatis;

import cn.liberfree.common.Page;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-08-21 15:55
 **/
@Intercepts({
//        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}),
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class,Integer.class}),
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class PagePlugin implements Interceptor {

    public Dialect dialect = Dialect.MYSQL;

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public PagePlugin(Dialect dialect) {
        this.dialect = dialect;
    }

    public PagePlugin() {
    }

    public static final Logger logger = LoggerFactory.getLogger(PagePlugin.class);

    static ThreadLocal<Long> tl = new ThreadLocal<>();
    static ThreadLocal<PageParames> tp = new ThreadLocal<>();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (!(invocation.getTarget() instanceof StatementHandler)) {
            if (invocation.getTarget() instanceof ResultSetHandler) {
                if (tp.get() == null) {
                    return invocation.proceed();
                } else {
                    Page page = new Page();
                    List list = (List)invocation.proceed();
                    page.setRows(list);
                    page.setPageIndex(((PageParames)tp.get()).getPageIndex());
                    page.setPageSize(((PageParames)tp.get()).getPageSize());
                    page.setTotalCount((Long)tl.get());
                    tp.remove();
                    tl.remove();
                    return page;
                }
            } else {
                return invocation.proceed();
            }
        } else {
            RoutingStatementHandler handler = (RoutingStatementHandler)invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
            BoundSql boundSql = delegate.getBoundSql();
            Object obj = boundSql.getParameterObject();
            PageParames pageParames = null;
            if (obj instanceof PageParames) {
                pageParames = (PageParames)obj;
            } else if (obj instanceof MapperMethod.ParamMap) {
                MapperMethod.ParamMap map = (MapperMethod.ParamMap)obj;
                Iterator var8 = map.entrySet().iterator();

                while(var8.hasNext()) {
                    Object entity = var8.next();
                    Map.Entry e = (Map.Entry)entity;
                    if (e.getValue() instanceof PageParames) {
                        pageParames = (PageParames)e.getValue();
                    }
                }
            }

            if (pageParames != null) {
                tp.set(pageParames);
                MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
                Connection connection = (Connection)invocation.getArgs()[0];
                String sql = boundSql.getSql();
                this.setTotalRecord(boundSql, mappedStatement, connection);
                String pageSql = this.getPageSql(pageParames, sql);
                 ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
            }

            return invocation.proceed();
        }
    }

    private void setTotalRecord(BoundSql boundSql, MappedStatement mappedStatement, Connection connection) {
        //获取对应的BoundSql，这个BoundSql其实跟我们利用StatementHandler获取到的BoundSql是同一个对象。
        //delegate里面的boundSql也是通过mappedStatement.getBoundSql(paramObj)方法获取到的。
//        BoundSql boundSql = mappedStatement.getBoundSql(page);
        //获取到我们自己写在Mapper映射语句中对应的Sql语句
        String sql = boundSql.getSql();
        //通过查询Sql语句获取到对应的计算总记录数的sql语句
        String countSql = this.getCountSql(sql);
        //通过BoundSql获取对应的参数映射
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        //利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, boundSql.getParameterObject());
        //通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
        //通过connection建立一个countSql对应的PreparedStatement对象。
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            //通过parameterHandler给PreparedStatement对象设置参数
            parameterHandler.setParameters(pstmt);
            //之后就是执行获取总记录数的Sql语句和获取结果了。
            rs = pstmt.executeQuery();
            if (rs.next()) {
                long totalRecord = rs.getLong(1);
                //给当前的参数page对象设置总记录数
                tl.set(totalRecord);
//                    page.setTotalRecord(totalRecord);
            }else{
                tl.set(0L);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getPageSql(PageParames page, String sql) {
        StringBuffer sqlBuffer = new StringBuffer(sql);

        switch (dialect){
            case MYSQL:
                sqlBuffer.append(" limit ").append((page.getPageIndex() - 1) * page.getPageSize()).append(",").append(page.getPageSize());
                break;
            case POSTGRESQL:
                sqlBuffer.append(" OFFSET  ").append((page.getPageIndex() - 1) * page.getPageSize()).append(" LIMIT ").append(page.getPageSize());
                break;
        }

        return sqlBuffer.toString();
    }

    private String getCountSql(String sql) {
        return "select count(1) from (" + sql + ") as t";
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        if(dialect != null && !"".equals(dialect)){
            Dialect dialect1 = Dialect.valueOf(dialect);
            if(dialect1 != null){
                this.dialect = dialect1;
            }
        }
    }


    private static class ReflectUtil {
        /**
         * 利用反射获取指定对象的指定属性
         *
         * @param obj       目标对象
         * @param fieldName 目标属性
         * @return 目标属性的值
         */
        public static Object getFieldValue(Object obj, String fieldName) {
            Object result = null;
            Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    result = field.get(obj);
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return result;
        }

        /**
         * 利用反射获取指定对象里面的指定属性
         *
         * @param obj       目标对象
         * @param fieldName 目标属性
         * @return 目标字段
         */
        private static Field getField(Object obj, String fieldName) {
            Field field = null;
            for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                } catch (NoSuchFieldException e) {
                    //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
                }
            }
            return field;
        }

        /**
         * 利用反射设置指定对象的指定属性为指定的值
         *
         * @param obj        目标对象
         * @param fieldName  目标属性
         * @param fieldValue 目标值
         */
        public static void setFieldValue(Object obj, String fieldName,
                                         String fieldValue) {
            Field field = ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                try {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    public enum Dialect{
        MYSQL,
        POSTGRESQL
    }


}
