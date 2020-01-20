package cn.liberfree.de.config;

import cn.liberfree.common.pojo.PojoMapperManager;
import cn.liberfree.de.core.BeanFactory;
import cn.liberfree.de.core.Generate;
import cn.liberfree.de.core.WorkingData;
import cn.liberfree.de.repository.IRepository;

/**
 * @author: zhangchao
 * @time: 2018-08-07 15:39
 **/
public interface  ContextConfig {

    Generate getGenerate();

    WorkingData getWorkingData();

    BeanFactory getBeanFactory();

    PojoMapperManager getPojoMapperManager();

    IRepository getIRepository(Class<? extends IRepository> entityObject);

}
