package com.cloud.blog.context.service.impl;

import com.cloud.blog.context.repository.mappers.AdvertisingDmoMapper;
import com.cloud.blog.context.repository.mappers.NavigationDmoMapper;
import com.cloud.blog.context.repository.mappers.TopicDmoMapper;
import com.cloud.blog.context.repository.mappers.TopicTypeDmoMapper;
import com.cloud.blog.context.repository.mappers.dmo.*;
import com.cloud.blog.context.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-17 15:44
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    NavigationDmoMapper navigationDmoMapper;

    @Autowired
    AdvertisingDmoMapper advertisingDmoMapper;

    @Autowired
    TopicDmoMapper topicDmoMapper;

    @Autowired
    TopicTypeDmoMapper topicTypeDmoMapper;


    @Override
    public List<NavigationDmo> getNavlist() {
        return navigationDmoMapper.selectByExample(new NavigationDmoExample());
    }


    @Override
    public List<TopicDmo> getTopicList() {
        return topicDmoMapper.selectByExample(new TopicDmoExample());
    }

    @Override
    public TopicDmo getTopic(String id) {
        return topicDmoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TopicTypeDmo> getTopicTypeList() {
        return topicTypeDmoMapper.selectByExample(new TopicTypeDmoExample());
    }

    @Override
    public List<AdvertisingDmo> getAdvertisingList(String code) {
        AdvertisingDmoExample advertisingDmoExample = new AdvertisingDmoExample();
        advertisingDmoExample.createCriteria().andCodeEqualTo(code);
        return advertisingDmoMapper.selectByExample(advertisingDmoExample);
    }
}
