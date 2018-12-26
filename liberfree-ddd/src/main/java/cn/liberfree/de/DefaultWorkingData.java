package cn.liberfree.de;

import cn.liberfree.de.cache.CacheManager;
import cn.liberfree.de.config.ContextConfig;
import cn.liberfree.de.core.SystemExecption;
import cn.liberfree.de.core.Operator;
import cn.liberfree.de.core.WorkingData;
import cn.liberfree.de.repository.EntityObject;
import cn.liberfree.de.repository.IRepository;
import cn.liberfree.de.repository.RepositoryLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-08-03 11:17
 **/
public class DefaultWorkingData implements WorkingData {

    private final static Logger logger = LoggerFactory.getLogger(DefaultWorkingData.class);

    @Override
    public Class getObjectClass() {
        return DefaultWorkingData.class;
    }

    private static ThreadLocal<Map<EntityObject,Operator>> mapThreadLocalSave = new ThreadLocal<Map<EntityObject,Operator>>();

    private ContextConfig contextConfig;

    public DefaultWorkingData( ) {
        this.contextConfig = ObjectFactory.getContextConfig();
    }

    @Override
    public void add(EntityObject entityObject,Operator operator) {
        this.getEntityMap().put(entityObject,operator);
    }

    @Override
    public Map<EntityObject, Operator> getEntityMap() {
        if (this.mapThreadLocalSave.get()==null) {
            this.mapThreadLocalSave.set(new HashMap<>());
        }
        return this.mapThreadLocalSave.get();
    }

    @Override
    public boolean isWriteData() {
        return !getEntityMap().isEmpty();
    }

    public void entityCommit(){
        Iterator<Map.Entry<EntityObject, Operator>> iterator =  getEntityMap().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<EntityObject, Operator> next = iterator.next();
            Operator value = next.getValue();
            EntityObject key = next.getKey();
            RepositoryLink annotation = key.getClass().getSuperclass().getAnnotation(RepositoryLink.class);
            if(annotation == null){
                logger.error("not find "+key.getClass().getName()+" requerd @RepositoryLink");
                throw new SystemExecption("not find "+key.getClass().getName()+" requerd @RepositoryLink");
            }
            IRepository repository = contextConfig.getIRepository(annotation.value());
            if(value == Operator.SAVE){
                repository.save(key);
                CacheManager.remove((Serializable)key.getId());
            }else if(value == Operator.REMOVE){
                repository.delete(key);
                CacheManager.remove((Serializable)key.getId());
            }
        }
    }


    @Override
    public void commit() {
        try {
            entityCommit();
        } catch (Exception e) {
            throw new SystemExecption("提交仓储失败 ",e);
        } finally {
            this.getEntityMap().clear();
        }
    }

    @Override
    public void rollback() {
        getEntityMap().clear();
    }
}
