package com.xlliu.service.spring.beanpostprocess;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author liuxiaolun
 * @Description: 注入注解
 * @date 2018-10-31 13:59:07
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected {
}
