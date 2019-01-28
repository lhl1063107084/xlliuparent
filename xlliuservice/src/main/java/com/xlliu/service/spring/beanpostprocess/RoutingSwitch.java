package com.xlliu.service.spring.beanpostprocess;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 13:57:48
 **/
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingSwitch {
    /**
     * 在配置系统中开关的属性名称，应用系统将会实时读取配置系统中对应开关的值来决定是调用哪个版本
     *
     * @return
     */
    String value() default "";
}
