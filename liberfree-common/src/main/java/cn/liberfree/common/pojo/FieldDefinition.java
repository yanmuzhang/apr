package cn.liberfree.common.pojo;

import java.lang.reflect.Field;

/**
 * @author: zhangchao
 * @time: 2018-09-04 16:14
 **/
@Deprecated
public class FieldDefinition {
    public String name;
    public Field field;
    private int index;


    public void setFieldValue(Object object,Object value){
        try {
            this.field.set(object,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getFieldValue(Object object){
        try {
            return this.field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
