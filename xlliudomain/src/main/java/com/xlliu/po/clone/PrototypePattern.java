package com.xlliu.po.clone;

import com.xlliu.po.Student;
import lombok.*;

/**
 * @author liuxiaolun
 * @Description: 原型类型
 * @date 2018-11-07 11:38:35
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PrototypePattern implements Cloneable {
    private String type;
    private Student student;


    public PrototypePattern clone() {
        try {
            PrototypePattern prototypePattern  = (PrototypePattern)super.clone();
            Student clone = prototypePattern.getStudent().clone();    //深克隆
            prototypePattern.setStudent(clone);
            return prototypePattern;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
