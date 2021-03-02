package cn.liberfree.common.exception;

/**
 * @author: zhangchao
 * @time: 2018-08-21 09:46
 **/
public class BusinessException extends CustomException {
    public BusinessException(String msg, Object... args) {
        super("500", msg, args);
    }

    public BusinessException(String code, String msg, Object... args) {
        super(code, msg, args);
    }
}
