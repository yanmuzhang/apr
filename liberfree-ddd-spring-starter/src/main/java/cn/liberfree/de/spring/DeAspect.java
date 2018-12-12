package cn.liberfree.de.spring;

import cn.liberfree.common.exception.BusinessException;
import cn.liberfree.de.ObjectFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zhangchao
 * @time: 2018-08-22 15:01
 **/
@Aspect
@Service
public class DeAspect {

    @Autowired
    private TransactionalCommit transactionalCommit;

    public static Logger logger = LoggerFactory.getLogger(DeAspect.class);

    @Around("execution(public * *(..)) && @within(org.springframework.stereotype.Service)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (BusinessException var5) {
            throw var5;
        } catch (SystemException var5) {
            throw var5;
        } catch (Throwable var6) {
            throw new BusinessException("系统异常", var6);
        }
        if (ObjectFactory.getContextConfig().getWorkingData().isWriteData()) {//工作空间中是否存在需要更新的对象,在决定是否开启事务
            transactionalCommit.transactionalCommit();
        }else{
            transactionalCommit.commit();
        }
        return result;
    }




}
