package cn.liberfree.de.loader;

import cn.liberfree.de.ObjectFactory;
import cn.liberfree.de.config.ContextConfig;
import cn.liberfree.de.core.EntityObjectUtils;
import cn.liberfree.de.core.Operator;
import cn.liberfree.de.core.WorkingData;
import cn.liberfree.de.repository.EntityObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-08-01 15:47
 **/
public abstract class BaseEntityLoader {

    public static final Logger log = LoggerFactory.getLogger(BaseEntityLoader.class);

    protected ContextConfig contextConfig;

    public BaseEntityLoader() {
        this.contextConfig = ObjectFactory.getContextConfig();
    }

    protected EntityObject createProxy(Class claz){
        return EntityObjectUtils.create(claz);
    }

    public abstract  <T extends EntityObject> T create(Class<? extends EntityObject> clazz);

    public abstract  <T extends EntityObject> T create(Serializable id,Class<? extends EntityObject> clazz);

    public abstract  <T extends EntityObject> T load(Serializable id, Class<? extends EntityObject> clazz);


    protected <T extends EntityObject> T loadByWork(Serializable id, Class<? extends EntityObject> clazz){
        WorkingData workingData = this.contextConfig.getWorkingData();
        Map.Entry<EntityObject, Operator> entryStream = workingData.getEntityMap().entrySet().stream().filter(map -> map.getKey().getId().equals(id) && clazz.isInstance(map.getKey())).findFirst().orElse(null);
        return entryStream == null?null:(T)entryStream.getKey();
    }

}
