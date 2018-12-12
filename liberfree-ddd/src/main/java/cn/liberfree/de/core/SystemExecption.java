package cn.liberfree.de.core;

/**
 * @author: zhangchao
 * @time: 2018-07-31 15:06
 **/
public class SystemExecption extends RuntimeException {
    public SystemExecption() {
        super();
    }

    public SystemExecption(String message) {
        super(message);
    }

    public SystemExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemExecption(Throwable cause) {
        super(cause);
    }

    protected SystemExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
