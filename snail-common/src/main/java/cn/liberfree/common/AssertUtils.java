package cn.liberfree.common;

import cn.liberfree.common.exception.BusinessException;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;

/**
 * @author: zhangchao
 * @time: 2018-12-13 15:36
 **/
public class AssertUtils {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(message);
        }
    }
    public static void isNull( Object object, String message) {
        if (object != null) {
            throw new BusinessException(message);
        }
    }

    public static void notEmpty(String object, String message) {
        if (object == null || "".equals(object)) {
            throw new BusinessException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(message);
        }
    }


}
