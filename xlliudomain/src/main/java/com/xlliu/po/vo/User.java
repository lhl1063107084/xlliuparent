package com.xlliu.po.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-12-24 17:56:34
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    @Id
    private String age;
}
