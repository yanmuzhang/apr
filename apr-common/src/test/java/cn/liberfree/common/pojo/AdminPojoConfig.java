package cn.liberfree.common.pojo;

/**
 * @author: zhangchao
 * @time: 2018-09-05 09:53
 **/
public class AdminPojoConfig extends AbstrctPojoConfig {

    @Override
    public void config(PojoConfig pojoConfig) throws NoSuchFieldException{
        pojoConfig.mapping(User.class,UserDmo.class,UserDto.class)
                .fileds("id","id","id")
                .fileds("name","name","name")
                .fileds("sex","sex2","sex1");
    }
}

class Base<T>{
    public T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
class User extends Base<String>{
    public String name;
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User() {
    }

    public User(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}

class UserDmo{
    public String id;
    public String name;
    public String sex2;
    public UserDmo() {
    }
    public UserDmo(String id, String name, String sex2) {
        this.id = id;
        this.name = name;
        this.sex2 = sex2;
    }
}

enum Sex{MAIL}

class UserDto{
    public String id;
    public String name;
    public Sex sex1;
    public UserDto() {
    }
    public UserDto(String id, String name, Sex sex1) {
        this.id = id;
        this.name = name;
        this.sex1 = sex1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex1() {
        return sex1;
    }

    public void setSex1(Sex sex1) {
        this.sex1 = sex1;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex1='" + sex1 + '\'' +
                '}';
    }
}