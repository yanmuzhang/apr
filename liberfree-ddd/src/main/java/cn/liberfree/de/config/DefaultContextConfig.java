package cn.liberfree.de.config;

import cn.liberfree.common.pojo.DefaultPojoMapperManager;
import cn.liberfree.common.pojo.PojoMapperManager;
import cn.liberfree.de.DefaultGenerate;
import cn.liberfree.de.DefaultWorkingData;
import cn.liberfree.de.RefalectBeanFatory;
import cn.liberfree.de.core.BeanFactory;
import cn.liberfree.de.core.Generate;
import cn.liberfree.de.core.WorkingData;
import cn.liberfree.de.repository.IRepository;

/**
 * @author: zhangchao
 * @time: 2018-08-22 12:07
 **/
public class DefaultContextConfig implements ContextConfig {


    private BeanFactory beanFactory;
    private Generate generate;
    private WorkingData workingData;
    private PojoMapperManager pojoMapperManager;


    @Override
    public Generate getGenerate() {
        if(generate == null){
            generate =  new DefaultGenerate();
        }
        return generate;
    }

    @Override
    public WorkingData getWorkingData() {
        if(workingData == null){
            workingData =  new DefaultWorkingData();
        }
        return workingData;
    }

    @Override
    public BeanFactory getBeanFactory() {
        if(beanFactory == null){
            beanFactory =  new RefalectBeanFatory();
        }
        return beanFactory;
    }

    @Override
    public PojoMapperManager getPojoMapperManager() {
        if(pojoMapperManager == null){
            pojoMapperManager =  new DefaultPojoMapperManager();
        }
        return pojoMapperManager;
    }

    @Override
    public IRepository getIRepository(Class<? extends IRepository> entityObject) {
        return getBeanFactory().getBean(entityObject);
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setGenerate(Generate generate) {
        this.generate = generate;
    }

}
