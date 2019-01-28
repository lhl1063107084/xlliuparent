package sort;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuxiaolun
 * @Description: 测试comparable 与 comparator
 * @date 2018-10-30 14:48:48
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompareComparatorAndComparableTest implements Comparable<CompareComparatorAndComparableTest> {

    private String name;
    private Integer age;


    @Override
    public int compareTo(CompareComparatorAndComparableTest o) {
        return name.compareTo(o.getName());
    }


    static class testComparator implements Comparator<CompareComparatorAndComparableTest> {

        @Override
        public int compare(CompareComparatorAndComparableTest o1, CompareComparatorAndComparableTest o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


    public static void main(String a[]) {
        List<CompareComparatorAndComparableTest> list = new ArrayList();
        list.add(new CompareComparatorAndComparableTest("eee", 1));
        list.add(new CompareComparatorAndComparableTest("bbb", 4));
        list.add(new CompareComparatorAndComparableTest("hhh", 3));
        list.add(new CompareComparatorAndComparableTest("aaa", 2));

        /**
         * comparable
         */
//        comparable(list);




        /**
         * comparator 原始版
         */
        comparator(list);

        /**
         * comparator 匿名内部类简化版(不需要外定义规则类)
         */
//        comparatorSort01(list);

        /**
         * comparator 终极版(使用java 1.8lambda表达式)
         */
//        comparatorSort02(list);


    }

    /**
     * 使用Comparable 排序
     * 相当于一个内置比较器
     * 要排序的类实现Comparable接口,重写compareTo(Object o) 自定义比较规则
     * 然后使用Collections.sort(list<实现comparable对象的类>);
     * 注意:如果一个list<String/Integer> 可以直接使用Collections.sort进行排序
     */
    public static void comparable(List<CompareComparatorAndComparableTest> list) {
        list.forEach(testComparable -> {
            System.out.println("排序前 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });

        Collections.sort(list);
        System.out.println("-----------");

        list.forEach(testComparable -> {
            System.out.println("排序后 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });
    }


    /**
     * 使用Comparator 排序
     * 相当于一个外部比较器
     * 定义一个规则类实现Comparable接口,重写compareTo(Object o1,Object o2) 自定义比较规则
     * 然后使用Collections.sort(list,规则类的实例)进行排序;
     */
    public static void comparator(List<CompareComparatorAndComparableTest> list) {
        list.forEach(testComparable -> {
            System.out.println("排序前 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });

        Collections.sort(list, new testComparator());
        System.out.println("-----------");


        list.forEach(testComparable -> {
            System.out.println("排序后 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });
    }


    /**
     * comparator 匿名内部类简化版(不需要外定义规则类)
     */
    public static void comparatorSort01(List<CompareComparatorAndComparableTest> list) {
        list.forEach(testComparable -> {
            System.out.println("排序前 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });

        System.out.println("-----------");

        //第二个参数采用匿名类的方式进行实现
        Collections.sort(list, new Comparator<CompareComparatorAndComparableTest>() {
            @Override
            public int compare(CompareComparatorAndComparableTest o1, CompareComparatorAndComparableTest o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        list.forEach(testComparable -> {
            System.out.println("排序后 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
        });
    }


    /**
     * comparator 终极版(使用java 1.8lambda表达是)
     */
//    public static void comparatorSort02(List<CompareComparatorAndComparableTest> list) {
//        list.forEach(testComparable -> {
//            System.out.println("排序前 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
//        });
//
//        System.out.println("-----------");
//
//        //第二个参数采用匿名类的方式进行实现
//        Collections.sort(list, ((o1, o2) -> {
//            return o2.getAge() - o1.getAge();
//        }));
//
//        list.forEach(testComparable -> {
//            System.out.println("排序后 name:" + testComparable.getName() + "---age:" + testComparable.getAge());
//        });
//    }


}
