package com.xlliu.service.spring.beanpostprocess.applicationaware;

import org.springframework.stereotype.Service;

/**
 * @author liuxiaolun
 * @Description: 测试接口实现
 * @date 2018-09-29 11:56:17
 **/
@Service
public class TestServiceImpl implements TestService {
    public String printStr(String param) {
        return param;
    }
}
