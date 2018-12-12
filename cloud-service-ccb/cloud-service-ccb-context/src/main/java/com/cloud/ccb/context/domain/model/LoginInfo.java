package com.cloud.ccb.context.domain.model;

import cn.liberfree.de.repository.ValueObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: zhangchao
 * @time: 2018-11-15 14:55
 **/
@Setter
@Getter
@NoArgsConstructor
public class LoginInfo extends ValueObject {
    private static final long serialVersionUID = 8821904931154902866L;
    public static final String DEFAULT_MARK = "123456";

    private String mark;

    public void changeMark(String mark) {
        this.mark = mark;
    }

    public enum Source{
        WECHAT,
        QQ,
        PHONE,
        PASSWORD,
        IMEI
    }

    public enum Status{
        /**
         * 绑定
         */
        BINDING,
        /**
         * 解绑
         */
        UN_BINDING
    }

    private Source source;

    private Status status;

    public void init(String mark, Source source, Status status) {
        this.mark = mark;
        this.source = source;
        this.status = status;
    }
}
