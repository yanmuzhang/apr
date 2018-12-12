package cn.liberfree.common.pojo;

import cn.liberfree.common.JsonUtils;

public class PojoMapperTest {

    public static void main(String[] args) {
        PojoMapper pojoMapper = new PojoMapper();
        pojoMapper.addMappingConfig(new AdminPojoConfig());
        User user = new User("1","JUCK","MAIL");
        long start = System.currentTimeMillis();
        for (int i = 1; i > 0; i--) {
            UserDto map = pojoMapper.map(user, UserDto.class);
            System.out.println(JsonUtils.toJSONNoFeatures(map));
        }
        long end = System.currentTimeMillis();
        System.out.println("POJO:"+(end-start)+"ms");

//        start = System.currentTimeMillis();
//        for (int i = 1; i > 0; i--) {
//            UserDto userDto = new UserDto();
//            try {
//                BeanUtilsBean2.getInstance().copyProperties(user,userDto);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//        end = System.currentTimeMillis();
//        System.out.println("BeanUtilsBean2:"+(end-start)+"ms");

        start = System.currentTimeMillis();
        for (int i = 1; i > 0; i--) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
//            userDto.setSex1(user.getSex());
        }
        end = System.currentTimeMillis();
        System.out.println("GetSet:"+(end-start)+"ms");


    }
}
