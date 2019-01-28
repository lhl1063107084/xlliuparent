package com.xlliu.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaolun
 * @Description:
 * @date 2018-12-28 14:55:23
 **/
@RefreshScope
@ConfigurationProperties
@Component("appConfigBean")
@Getter
@ToString
public class AppConfigBean {
//    @Value("${test.apollo}")
//    private String apollo;
}
