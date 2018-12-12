package cn.liberfree.common.exception;

import cn.liberfree.common.JsonUtils;

/**
 * @author: zhangchao
 * @time: 2018-12-11 19:10
 **/
public abstract class CustomException extends RuntimeException {
    private String errorCode;
    private Object[] arguments;

    public CustomException(String errorCode, String message, Object... arguments) {
        super(message);
        this.errorCode = errorCode;
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.getMessage() + "\r\n");
        stringBuilder.append("errorCode:" + this.errorCode + "\r\n");
        stringBuilder.append("输入参数：\r\n");
        Object[] var2 = this.arguments;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Object argument = var2[var4];
            stringBuilder.append("\t" + JsonUtils.convertObjectToJSON(argument) + "\r\n");
        }

        return stringBuilder.toString();
    }
}

