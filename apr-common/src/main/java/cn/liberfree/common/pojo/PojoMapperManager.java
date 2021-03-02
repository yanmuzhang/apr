package cn.liberfree.common.pojo;

/**
 * @author: zhangchao
 * @time: 2018-08-30 17:10
 **/
@Deprecated
public interface PojoMapperManager {

    void addTypeDefinition(String key,TypeDefinition typeDefinition);

    TypeDefinition getTypeDefinition(String key);

}
