package cn.liberfree.de.loader;

import cn.liberfree.common.utils.ReflectUtils;
import cn.liberfree.de.cache.CacheManager;
import cn.liberfree.de.repository.BaseEntityObject;
import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.IRepository;
import cn.liberfree.de.repository.RepositoryLink;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-07-30 18:04
 **/
public class EntityLoader extends BaseEntityLoader {

    @Override
    public <T extends EntityObject> T create(Class<? extends EntityObject> clazz) {
        return create((Serializable) contextConfig.getGenerate().id(),clazz);
    }

    @Override
    public <T extends EntityObject> T create(Serializable id, Class<? extends EntityObject> clazz) {
        EntityObject o = super.createProxy(clazz);
        o.setId(id);
        ReflectUtils.reflect(o).field(BaseEntityObject.IS_PROXY,true);
        ReflectUtils.reflect(o).field(BaseEntityObject.IS_LOAD,false);
        return (T)o ;
    }

    @Override
    public <T extends EntityObject> T load(Serializable id, Class<? extends EntityObject> clazz) {
        EntityObject entityObject = loadByWork(id, clazz);
        if(entityObject != null){
            log.info("get data for unwork id={}"+entityObject.getId());
            return (T)entityObject;
        }
        entityObject = (EntityObject)CacheManager.get(id);
        if(entityObject != null){
            log.info("get data for cache id={}"+entityObject.getId());
            return (T)entityObject;
        }

        IRepository iRepository = super.contextConfig.getIRepository(clazz.getAnnotation(RepositoryLink.class).value());

        entityObject = iRepository.load(id, this);
        if(entityObject != null){
            CacheManager.set(id,entityObject);
            ReflectUtils.reflect(entityObject).field(BaseEntityObject.IS_LOAD,false);
        }
        return (T)entityObject;
    }
}
