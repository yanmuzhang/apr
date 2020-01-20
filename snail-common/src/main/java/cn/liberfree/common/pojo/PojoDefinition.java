package cn.liberfree.common.pojo;

import java.lang.reflect.Field;

/**
 * @author: zhangchao
 * @time: 2018-09-04 16:14
 **/
@Deprecated
public class PojoDefinition {
    public String name;
    public Field field;
    public Object value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
