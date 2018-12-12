package cn.liberfree.common.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-09-04 16:14
 **/
@Deprecated
public class TypeDefinition {
    private String name;
    private Class<?> aClass;



    private List<FieldDefinition> fieldDefinitionList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }

    public List<FieldDefinition> getFieldDefinitionList() {
        return fieldDefinitionList;
    }


    public void addFieldDefinition(FieldDefinition fieldDefinition) {
        this.fieldDefinitionList.add(fieldDefinition);
    }

    public FieldDefinition getFieldDefinition(int index) {
        if(fieldDefinitionList.size() < index){
            return null;
        }
        return fieldDefinitionList.get(index);
    }
    public FieldDefinition getFieldDefinition(String name) {
        return fieldDefinitionList.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
    }
}
