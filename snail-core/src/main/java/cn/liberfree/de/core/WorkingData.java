package cn.liberfree.de.core;

import cn.liberfree.de.repository.EntityObject;

import java.util.Map;

/**
 * 工作数据区
 *
 * @author: zhangchao
 * @time: 2018-08-03 11:14
 **/
public interface WorkingData extends Context{


    public void add(EntityObject entityObject,Operator operator);

    boolean isWriteData();

    public void commit();

    public void rollback();

    public Map<EntityObject,Operator> getEntityMap();

}
