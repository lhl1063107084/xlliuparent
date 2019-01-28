package com.xlliu.service.sort;

import java.util.Arrays;

/**
 * @author liuxiaolun
 * @Description: 排序
 * @date 2018-11-22 16:00:26
 **/
public class Sort {

    /**
     * 冒泡排序 每当俩相邻的数比较后发现他们的排序与排序的要求相反时，就将他们交换。每次遍历都可确定一个最大值放到待排数组的末尾。
     */
    public static Integer[] bubbleSort(Integer[] a) {
        Integer count = 0;

        Integer temp = null;
        for (int i = 0; i < a.length - 1; i++) {//确定循环次数
            for (int j = 0; j < a.length - i - 1; j++) {
                count++;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("冒泡排序第" + (i + 1) + "次排序结果为" + Arrays.toString(a));
        }
        System.out.println("冒泡排序总循环次数:" + count);
        return a;
    }

    /**
     * 冒泡排序优化1
     * 记录内层循环位置是否改变,如果该次循环没有发生位置改变,证明排序完毕,跳出循环。
     */
    public static Integer[] bubbleSort01(Integer[] a) {
        Boolean isChange = null;
        Integer count = 0;

        Integer temp = null;
        for (int i = 0; i < a.length - 1; i++) {//确定循环次数
            isChange = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                count++;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isChange = true;
                }
            }
            System.out.println("冒泡排序优化1第" + (i + 1) + "次排序结果为" + Arrays.toString(a));
            if (!isChange) { //位置没发生改变,跳出循环
                break;
            }
        }
        System.out.println("冒泡排序优化1总循环次数:" + count);
        return a;
    }


    /**
     * 冒泡排序优化2
     * 每次循环最后面的几个数已经排序完毕无需进行新一轮的比较,设置指针记录不需要比较的位置。
     */
    public static Integer[] bubbleSort02(Integer[] a) {
        Integer counter = 0;

        Integer count = 0;
        Integer temp = null;
        int endPoint = a.length - 1; //endPoint代表最后一个需要比较的元素下标
        while (endPoint > 0) {
            counter++;
            int pos = 0;
            for (int j = 0; j < endPoint; j++) {
                count++;
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    pos = j; //最后一个交换位置的下标
                }
            }
            endPoint = pos;  //下一轮排序时只对下标小于pos的元素排序,下标大于等于pos的元素已经排好
            System.out.println("第" + counter + "次排序结果为" + Arrays.toString(a));
        }

        System.out.println("总循环次数:" + count);
        return a;
    }


    /**
     * 选择排序 从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推。
     */
    public static Integer[] selectSort(Integer a[]) {
        int minPoint = 0;//最小元素的下标
        int length = a.length;//数组长度
        int temp = 0;

        for (int i = 0; i < length - 1; i++) {
            minPoint = i;

            for (int j = i; j < length - 1; j++) {//每外层循环一次,下一次的时候,寻找最小数组初始位置将加1;
                if (a[j] < a[minPoint]) {
                    minPoint = j;
                }
            }

            if (minPoint != i) { //证明走了内层循环,找到了最小元素,交换位置
                temp = a[i];
                a[i] = a[minPoint];
                a[minPoint] = temp;
            }
        }
        return a;
    }

    /**
     * 插入排序 假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    public static void insertSort(Integer[] a) {
        int length = a.length;
        for (int i = 1; i <= length - 1; i++) {
            int array = a[i];//需要排序的元素
            int firsIndex = i - 1;//第一次需要比较的元素下标
            while (firsIndex >= 0 && a[firsIndex] > array) {//需要排序的元素大于他前面的元素则需要交换位置
                a[firsIndex + 1] = a[firsIndex];//大的元素后移
                firsIndex--; //比较的下标自减1进行下一次比较
            }
            a[firsIndex + 1] = array;//比较完毕 插入

            System.out.println("第" + i + "次排序结果为" + Arrays.toString(a));
        }
    }


    /**
     * 插入排序01
     */
    public static void insertSort01(Integer[] a) {
        //   Integer[] b = {0, 1, 4, 2, 11, 18, 20};
        int length = a.length;
        for (int i = 1; i <= length - 1; i++) {
            int firsIndex = i - 1;//第一次需要比较的元素下标
            int array = a[i];

            if (array < a[firsIndex]) {
                //采用二分法找到要插入的位置
                int binarySerach = binarySerach(0, i - 1, a, a[i]);
                for (int j = i; binarySerach < j; j--) {  //将有序数组中，插入点之后的元素后移一位
                    a[j] = a[j - 1];
                }
                a[binarySerach] = array;
            }


            System.out.println("第" + i + "次排序结果为" + Arrays.toString(a));
        }
    }

    /**
     * 二分法找到需要插入的位置
     */
    static int binarySerach(int lowerBound, int upperBound, Integer[] array, int key) {
        int left = lowerBound;
        int right = upperBound - 1;

        // 这里必须是 <=
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 查找第一个相等的元素
    static int findFirstEqual(Integer[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }


    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }

    public static void main(String arg[]) {
//        Integer[] b = {0, 1, 10, 4};
//        bubbleSort(b);//排序在第三次循环完成,但是依然会执行length-1次   总循环次数21次
//        bubbleSort01(b);//排序在第三次循环完成,执行第四次没有发生位置改变,跳出循环,执行有效循环次数+1次  总循环次数18次。
//        System.out.println(binarySearch(b, 20));

        Integer a[] = {1, 4, 20, 50};
        Integer b[] = {1, 2, 16, 100};
        merge(a, b);
    }


    //二分法查找
    public static int binarySearch(Integer a[], int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                right = mid - 1; //right -1 与 left + 1 仅仅是保证存在left > right 以至于结束循环 单方面
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void merge(Integer a[], Integer b[]) {
        Integer[] c = new Integer[a.length + b.length];

        int i = 0, j = 0, k = 0;//记录a b c 数组的下标
        while (i < a.length && j < a.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) { //a 不为空 b为空
            c[k++] = a[i++];
        }

        while (j < a.length) { //b 不为空 a为空
            c[k++] = b[j++];
        }

        System.out.println(Arrays.toString(c));
    }
}
