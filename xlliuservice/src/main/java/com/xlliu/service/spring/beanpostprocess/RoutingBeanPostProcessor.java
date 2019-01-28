package com.xlliu.service.spring.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 14:04:54
 **/
//@Component
public class RoutingBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    private void handleRoutingInjected(Field field, Object bean, Class type) throws IllegalAccessException {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() == 1) {
            field.set(bean, candidates.values().iterator().next());
        } else if (candidates.size() == 2) {
            Object proxy = RoutingBeanProxyFactory.createProxy(type, candidates);
            field.set(bean, proxy);
        } else {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        Class clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(RoutingInjected.class)) {
                if (!f.getType().isInterface()) {
                    throw new BeanCreationException("RoutingInjected field must be declared as an interface:" + f.getName()
                            + " @Class " + clazz.getName());
                }
                try {
                    this.handleRoutingInjected(f, bean, f.getType());
                } catch (IllegalAccessException e) {
                    throw new BeanCreationException("Exception thrown when handleAutowiredRouting", e);
                }
            }
        }
        return bean;
    }
}
