package cn.liberfree.common.pojo;


import cn.liberfree.common.exception.BusinessException;

/**
 * @author: zhangchao
 * @time: 2018-09-04 16:57
 **/
@Deprecated
public class MappingExecption extends BusinessException {
    public MappingExecption(String message) {
        super(message);
    }

    public MappingExecption(String code, String message) {
        super(code, message);
    }

    public MappingExecption(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public MappingExecption(String code, Throwable cause) {
        super(code, cause);
    }

    public MappingExecption(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
