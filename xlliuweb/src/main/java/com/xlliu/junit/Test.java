package com.xlliu.junit;

import com.xlliu.Application;
import com.xlliu.service.mongo.impl.UserRepositoryImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-12-24 17:07:17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {
    @Autowired
    private UserRepositoryImpl userRepository;

    @org.junit.Test
    public void save() {
        userRepository.save01();
        System.out.println("success");
    }
}
