package com.xlliu.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuxiaolun
 * @Description: 配置文件映射类
 * @date 2018-12-27 10:06:45
 **/
@Component
@ConfigurationProperties(prefix = "server")
@Getter
@Setter
@ToString
public class Props {
    private Integer port;
}
