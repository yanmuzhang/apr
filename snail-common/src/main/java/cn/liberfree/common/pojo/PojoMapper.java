package cn.liberfree.common.pojo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-30 17:10
 **/
@Deprecated
public class PojoMapper {
    private List<AbstrctPojoConfig> abstrctPojoConfigList = new ArrayList<>();
    public void addMappingConfig(AbstrctPojoConfig abstrctPojoConfig){
        try {
            abstrctPojoConfig.config.end();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        this.abstrctPojoConfigList.add(abstrctPojoConfig);
    }

    public <T> T map(Object source,Class<T> target){
        Object bean = null;
        try {
            bean = target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new MappingExecption(e.getMessage());
        }
        map(source,bean);
        return (T)bean;
    }

    public void map(Object source,Object target){
        Class<?> aClass = source.getClass();
        Class<?> aClass1 = target.getClass();
        if(isPojoConfig(aClass)){
            this.mapByConfig(aClass,aClass1,source,target);
        }else{
            List<Field> fields = Arrays.asList(aClass.getDeclaredFields());
            for (Field field : aClass1.getDeclaredFields()) {
                try {
                    Field field2 = fields.stream().filter(i -> i.getName().equals(field.getName()) ).findFirst().orElse(null);
                    if(field2 != null){
                        field2.setAccessible(true);
                        field.setAccessible(true);
                        field.set(target,(Object) field2.get(source));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void mapByConfig( Class<?> aClass, Class<?> aClass1,Object source,Object target){
        TypeDefinition sourceDefinition = PojoConfig.pojoMapperManager.getTypeDefinition(aClass.getName());
        TypeDefinition targetDefinition = PojoConfig.pojoMapperManager.getTypeDefinition(aClass1.getName());
        targetDefinition.getFieldDefinitionList().stream().forEach(item -> {
            FieldDefinition fieldDefinition = sourceDefinition.getFieldDefinition(item.getIndex());
            item.setFieldValue(target,fieldDefinition.getFieldValue(source));
        });
    }

    private boolean isPojoConfig(Class<?> aClass){
        return PojoConfig.pojoMapperManager.getTypeDefinition(aClass.getName()) != null;
    }

}
