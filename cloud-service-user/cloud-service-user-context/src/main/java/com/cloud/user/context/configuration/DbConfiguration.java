package com.cloud.user.context.configuration;

import com.cloud.ddd.loader.EntityLoader;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author: zhangchao
 * @time: 2018-07-30 16:42
 **/
@Configuration
public class DbConfiguration {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean(name="sqlSessionFactory")
//    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws IOException {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        Resource[] resources = new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:com/example/demo3/mapper/*Mapper.xml");
//        sessionFactory.setMapperLocations(resources);
//        return sessionFactory;
//    }


    @Bean
    public EntityLoader entityLoader(){
        return new EntityLoader();
    }

}
