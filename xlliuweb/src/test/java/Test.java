import com.xlliu.po.Student;
import com.xlliu.po.clone.CloneFactory;
import com.xlliu.po.clone.PrototypeManager;
import com.xlliu.po.clone.PrototypePattern;
import com.xlliu.po.clone.PrototypePattern01;

import java.util.Stack;

/**
 * @author liuxiaolun
 * @Description: 测试类
 * @date 2018-10-31 13:51:26
 **/
public class Test {
    public static void main(String a[]) throws NoSuchFieldException, IllegalAccessException {
        //浅克隆 基本数据类型复制一份给新的，非基本数据类型复制一份引用给新的(新旧内存地址一样)
        PrototypePattern pattern = new PrototypePattern();
        Student student = new Student();
        student.setId(123);
        student.setMarry("Marry");
        pattern.setStudent(student);
        pattern.setType("1");
        //克隆
        PrototypePattern pattern1 = pattern.clone();

        System.out.println("是否是同一对象:" + String.valueOf(pattern == pattern1));
        System.out.println("type类型是否一样:" + String.valueOf(pattern.getType() == pattern1.getType()));
        System.out.println("原来的非基本数据类型内存地址:" + String.valueOf(pattern.getStudent()));
        System.out.println("现在的非基本数据类型内存地址:" + String.valueOf(pattern1.getStudent()));


        //尝试修改新的克隆对象里面的非基本数据类型属性  - 可见修改新的旧的也会发生改变
        pattern1.getStudent().setId(456);
        System.out.println("旧:"+pattern.getStudent().getId());
        System.out.println("新:"+pattern1.getStudent().getId());


        /**
         * 克隆的过程,客户端不想看到。想根据传入不同原型对象的类型,得到对应的克隆对象。
         * 新建一个原型对象的抽象,获取克隆方法入参采用抽象类型接收。
         */
        CloneFactory prototypeClone01 = PrototypeManager.getPrototypeClone(new PrototypePattern01());
        System.out.println(prototypeClone01);
        CloneFactory prototypeClone011 = PrototypeManager.getPrototypeClone(new PrototypePattern01());
        System.out.println(prototypeClone011);





    }




}
