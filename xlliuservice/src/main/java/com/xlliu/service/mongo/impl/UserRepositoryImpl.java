package com.xlliu.service.mongo.impl;

import com.xlliu.po.vo.User;
import com.xlliu.service.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-12-24 15:08:40
 **/
@Service
public class UserRepositoryImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void save() {
        User user = new User();
        user.setAge("123aasdf");
        user.setName("刘小轮01");
        userRepository.save(user);
    }

    public void save01() {
        User user = new User();
        user.setAge("2");
        user.setName("刘小轮02");
        mongoTemplate.insert(user);
    }
}
