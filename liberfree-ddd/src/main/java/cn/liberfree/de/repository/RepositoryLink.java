package cn.liberfree.de.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: zhangchao
 * @time: 2018-08-03 11:43
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RepositoryLink {
    Class<? extends IRepository>  value() ;
}
