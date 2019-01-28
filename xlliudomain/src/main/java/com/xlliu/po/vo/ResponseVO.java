package com.xlliu.po.vo;

import lombok.*;

/**
 * @author liuxiaolun
 * @Description: 返回实体定义
 * @date 2018-11-01 14:01:41
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {
    private T result;
}
