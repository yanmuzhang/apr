package cn.liberfree.common;

import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-08-20 17:50
 **/
public abstract class IdentifyUtils {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
