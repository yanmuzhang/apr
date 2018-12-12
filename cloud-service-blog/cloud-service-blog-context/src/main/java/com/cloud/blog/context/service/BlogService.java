package com.cloud.blog.context.service;

import com.cloud.blog.context.repository.mappers.dmo.AdvertisingDmo;
import com.cloud.blog.context.repository.mappers.dmo.NavigationDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicDmo;
import com.cloud.blog.context.repository.mappers.dmo.TopicTypeDmo;

import java.util.List;

/**
 * @author: zhangchao
 * @time: 2018-08-17 15:43
 **/
public interface BlogService {
    List<NavigationDmo> getNavlist();

    List<TopicDmo> getTopicList();

    TopicDmo getTopic(String id);

    List<TopicTypeDmo> getTopicTypeList();

    List<AdvertisingDmo> getAdvertisingList(String code);
}
