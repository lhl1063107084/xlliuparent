package com.xlliu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaolun
 * @Description: 启动类
 * @date 2018-09-29 11:09:30
 **/
//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
//        org.flowable.spring.boot.SecurityAutoConfiguration.class})
@SpringBootApplication
//@EnableApolloConfig
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }


}
