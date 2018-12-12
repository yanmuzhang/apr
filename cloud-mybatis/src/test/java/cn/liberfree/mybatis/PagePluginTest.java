package cn.liberfree.mybatis;

import cn.liberfree.common.Page;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.postgresql.jdbc2.optional.SimpleDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PagePluginTest {
    public static final Logger logger = LoggerFactory.getLogger(PagePluginTest.class);

    public static void main(String[] args) throws Exception{
        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("cloud-user");
        dataSource.setUser("postgres");
        dataSource.setPassword("admin");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.addMapper(UserMapper.class);

        configuration.addInterceptor(new PagePlugin(PagePlugin.Dialect.POSTGRESQL));

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(configuration);

        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = configuration.getMapper(UserMapper.class, sqlSession);
        Page<Map<String, Object>> page = mapper.findUser(PageParames.create(1, 10));
        logger.debug("getTotalCount {}",page.getTotalCount());
        logger.debug("getRows{}",page.getRows().size());
        logger.debug("getTotalPage {}",page.getTotalPage());

    }
}
