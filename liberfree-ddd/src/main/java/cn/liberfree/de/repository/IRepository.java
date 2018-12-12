package cn.liberfree.de.repository;

import cn.liberfree.de.loader.EntityLoader;

import java.io.Serializable;

public interface IRepository<T extends EntityObject,PK extends Serializable> {

    public T load(PK id,EntityLoader loader);

    public void save(T object);

    public void delete(T object);

}
