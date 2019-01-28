package com.xlliu.service.user.impl;

import com.xlliu.po.Student;
import com.xlliu.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaolun
 * @Description: 实现
 * @date 2018-11-01 14:05:28
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<Student> getLisStudent() {
        Student student = new Student();
        student.setUserName("测试");
        List<Student> list = new ArrayList<>();
        list.add(student);
//        return studentMapper.selectByExample(new StudentExample());
        return list;
    }
}
