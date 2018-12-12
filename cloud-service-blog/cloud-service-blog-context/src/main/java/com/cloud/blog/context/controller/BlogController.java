package com.cloud.blog.context.controller;

import com.cloud.blog.context.repository.mappers.dmo.AdvertisingDmo;
import com.cloud.blog.context.repository.mappers.dmo.NavigationDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicTypeDmo;
import com.cloud.blog.context.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-17 15:43
 **/
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;


    @GetMapping("/nav")
    public List<NavigationDmo> getNavlist(){
        return blogService.getNavlist();
    }

    @GetMapping("/topic")
    public List<TopicDmo> getTopicList(){
        return blogService.getTopicList();
    }

    @GetMapping("/topic/{id}")
    public TopicDmo getTopicList(@PathVariable("id") String id){
        return blogService.getTopic(id);
    }

    @GetMapping("/topicType")
    public List<TopicTypeDmo> getTopicTypeList(){
        return blogService.getTopicTypeList();
    }

    @GetMapping("/advertising/{code}")
    public List<AdvertisingDmo> getAdvertisingList(@PathVariable("code") String code){
        return blogService.getAdvertisingList(code);
    }

}
