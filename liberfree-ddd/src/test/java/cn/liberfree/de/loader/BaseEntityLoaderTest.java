package cn.liberfree.de.loader;

import cn.liberfree.de.repository.EntityObject;

public class BaseEntityLoaderTest {


    public static void main(String[] args) {
        EntityLoader loader = new EntityLoader();

        Ad entityObject = loader.create(Ad.class);

        System.out.println(entityObject.getName());
    }




}

class Ad extends EntityObject<String>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}