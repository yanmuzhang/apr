package com.cloud.webapi.context.jwt;

/**
 * @author: zhangchao
 * @time: 2018-12-18 11:19
 **/
public class NoLoginException extends RuntimeException {
    private static final long serialVersionUID = -5472779279797001784L;

    public NoLoginException() {
        super();
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLoginException(Throwable cause) {
        super(cause);
    }

    protected NoLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
