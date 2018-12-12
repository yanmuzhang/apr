package cn.liberfree.common.pojo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhangchao
 * @time: 2018-09-04 16:39
 **/
@Deprecated
public class DefaultPojoMapperManager implements PojoMapperManager {

    private Map<String,TypeDefinition> pojoMapperMap = new ConcurrentHashMap<>();

    @Override
    public void addTypeDefinition(String key, TypeDefinition pojoMapper) {
        this.pojoMapperMap.put(key,pojoMapper);
    }

    @Override
    public TypeDefinition getTypeDefinition(String key) {
        return  this.pojoMapperMap.get(key);
    }
}
