package model;

import lombok.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 18:01:57
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int id;
    private String address;


    public static void main(String a[]) throws Exception {
        /*

         * 实列化类 方法 1

         */

        //String classPath = "com.whbs.bean.UserBean";

        //Class cla = Test1.class.getClassLoader().loadClass(classPath);

        //Object ob = cla.newInstance();



        /*

         * 实列化类 方法 2

         */

        UserBean bean = new UserBean();

        bean.setId(100);

        bean.setAddress(" 武汉 ");


        // 得到类对象

        Class userCla = bean.getClass();



        /*

         * 得到类中的所有属性集合

         */

        Field[] fs = userCla.getDeclaredFields();

        for (int i = 0; i < fs.length; i++) {

            Field f = fs[i];

            f.setAccessible(true); // 设置些属性是可以访问的

            Object val = f.get(bean); // 得到此属性的值


            System.out.println("name:" + f.getName() + "/t value = " + val);


            String type = f.getType().toString(); // 得到此属性的类型

            if (type.endsWith("String")) {

                System.out.println(f.getType() + "/t 是 String");

                f.set(bean, "12");        // 给属性设值

                System.out.println("重新复制之后的值:" + f.get(bean));

            } else if (type.endsWith("int") || type.endsWith("Integer")) {

                System.out.println(f.getType() + "/t 是 int");

                f.set(bean, 12);       // 给属性设值
                System.out.println("重新复制之后的值:" + f.get(bean));

            } else {

                System.out.println(f.getType() + "/t");

            }


        }





        /*

         * 得到类中的方法

         */

        Method[] methods = userCla.getMethods();

        for (int i = 0; i < methods.length; i++) {

            Method method = methods[i];

            if (method.getName().startsWith("get")) {

                System.out.print("methodName:" + method.getName() + "/t");

                System.out.println("value:" + method.invoke(bean)); // 得到 get 方法的值

            }

        }

        System.out.println(bean.getAddress());

    }

}
