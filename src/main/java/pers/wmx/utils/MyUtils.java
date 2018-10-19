package pers.wmx.utils;

/**
 * 工具类
 *
 * @author: wangmingxin1
 * @create: 2018-10-19 17:54
 **/
public class MyUtils {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
