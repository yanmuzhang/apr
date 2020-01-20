package cn.liberfree.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author: zhangchao
 * @time: 2018-12-11 20:18
 **/
public class ApiErrorResponse {

    private String code;
    private String message;
    private String clazz;
    private String cause;

    public ApiErrorResponse(String code,String clazz, String message, Exception exception) {

        this.code = code;
        this.clazz = clazz;
        this.message = message;

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        pw.close();
        this.cause = sw.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
