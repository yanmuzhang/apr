package cn.liberfree.mybatis;

import cn.liberfree.common.Page;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2018-08-23 10:59
 **/
public interface UserMapper {

    @Select("select * from t_user ")
    Page<Map<String,Object>> findUser(PageParames pageParames);
}
