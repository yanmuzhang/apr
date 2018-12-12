package com.cloud.user.context.repository.mappers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class UserLoginDmoMapperTest {

    @Test
    public void insert() {
    }


    public static void main(String[] args) {

//        EntityLoader loader = new EntityLoader();
//        User load = loader.load(User.class);
//        System.out.println(load.getAge());

//        List<Integer> integerList = new ArrayList<Integer>();
//        integerList.add(1);
//        integerList.add(12);
//        integerList.add(122);
//        integerList.add(142);

        List<Integer> integerList = null;



        List<String> collect = Optional.ofNullable(integerList).orElse(Collections.emptyList()).stream().filter(i -> i>0) .map(i -> i + "").collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));

    }
}
