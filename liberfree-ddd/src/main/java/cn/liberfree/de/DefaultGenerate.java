package cn.liberfree.de;

import cn.liberfree.de.core.Generate;

import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-07-31 15:18
 **/
public class DefaultGenerate implements Generate {
    @Override
    public Class getObjectClass() {
        return null;
    }

    public Object id() {
        return UUID.randomUUID().toString().toUpperCase().replace("-","");
    }
}
