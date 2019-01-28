package com.xlliu.controller;

import com.xlliu.po.Student;
import com.xlliu.po.vo.ResponseVO;
import com.xlliu.service.proxy.MyProxy;
import com.xlliu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;
import java.util.List;


/**
 * @author liuxiaolun
 * @Description: user库
 * @date 2018-11-01 13:59:50
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/student/list")
    public ResponseVO getListStudent() {
//        ApplicationContext context = SpringContextHolder.getContext();
//        UserService userService = (UserService) context.getBean("userServiceImpl");
        MyProxy proxy = new MyProxy(userService);

        UserService o = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class<?>[]{UserService.class}, proxy);
        List<Student> lisStudent = o.getLisStudent();
        return new ResponseVO(lisStudent);
    }

}
