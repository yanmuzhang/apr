package cn.liberfree.common.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-30 17:11
 **/
@Deprecated
public class PojoConfig {

    public static PojoMapperManager pojoMapperManager = new DefaultPojoMapperManager();

    private List<Class<?>> classList = new ArrayList<>();
    private List<List<String>> filedList = new ArrayList<>();

    public PojoConfig mapping(Class<?>...clazz){
        classList.addAll(Arrays.asList(clazz));
        return this;
    }

    public PojoConfig fileds(String...filed){
        filedList.add(Arrays.asList(filed));
        return this;
    }

    public TypeDefinition getTypeDefinition(Class clazz){
        return pojoMapperManager.getTypeDefinition(clazz.getName());
    }

    protected void end() throws NoSuchFieldException{
        int classSize = classList.size();
        for (int i = 0; i < classList.size(); i++) {
            TypeDefinition  typeDefinition = new TypeDefinition();
            typeDefinition.setaClass(classList.get(i));
            typeDefinition.setName(typeDefinition.getaClass().getName());
            int j = 0;
            for (List<String> fields : filedList) {
                if(fields.size() != classSize){
                    throw new MappingExecption("The number of fields is not equal :"+fields);
                }
                FieldDefinition fieldDefinition = new FieldDefinition();
                fieldDefinition.setName(fields.get(i));
                fieldDefinition.setIndex(j);
                fieldDefinition.setField(typeDefinition.getaClass().getField(fieldDefinition.getName()));
                typeDefinition.addFieldDefinition(fieldDefinition);
                j++;
            }
            pojoMapperManager.addTypeDefinition(typeDefinition.getName(),typeDefinition);
        }
    }




}
