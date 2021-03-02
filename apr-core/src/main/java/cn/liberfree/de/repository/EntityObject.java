package cn.liberfree.de.repository;

import cn.liberfree.de.ObjectFactory;
import cn.liberfree.de.core.Operator;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-07-30 17:54
 **/
public abstract class EntityObject<T> extends BaseEntityObject implements Serializable {
    private static final long serialVersionUID = 7530045194570996120L;
    private T id;

    public EntityObject() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }


    private void addToUnitOfWork(){
        ObjectFactory.getContextConfig().getWorkingData().add(this,Operator.SAVE);
    }

    public void delete(){
        ObjectFactory.getContextConfig().getWorkingData().add(this,Operator.REMOVE);
    }
}
