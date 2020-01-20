package cn.liberfree.de.spring;

/**
 * @author: zhangchao
 * @time: 2018-11-13 17:33
 **/

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DeConfiguretion.class})
public @interface EnableDe {
}
