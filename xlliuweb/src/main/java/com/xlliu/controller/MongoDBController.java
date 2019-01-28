package com.xlliu.controller;

import com.xlliu.service.mongo.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-12-24 15:16:32
 **/
@RestController
@RequestMapping("/mongo")
public class MongoDBController {
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @RequestMapping("/save")
    public String save() {
        userRepositoryImpl.save();
        return "success";
    }
}
