package cn.liberfree.de.spring;

import cn.liberfree.de.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zhangchao
 * @time: 2018-11-16 11:26
 **/
@Component
public class TransactionalCommit {

    @Transactional
    public void transactionalCommit(){
        ObjectFactory.getContextConfig().getWorkingData().commit();
    }


    public void commit(){
        ObjectFactory.getContextConfig().getWorkingData().commit();
    }

}
