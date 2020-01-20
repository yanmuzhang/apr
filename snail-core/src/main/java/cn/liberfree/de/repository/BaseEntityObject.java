package cn.liberfree.de.repository;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-08-01 14:13
 **/
public class BaseEntityObject implements Serializable {
    private static final long serialVersionUID = -6864801128926181930L;
    public static final String IS_LOAD = "isLoad";
    public static final String IS_PROXY = "isProxy";
    private transient boolean isLoad = true;
    private transient boolean isProxy = true;

    public BaseEntityObject() {
    }




}
