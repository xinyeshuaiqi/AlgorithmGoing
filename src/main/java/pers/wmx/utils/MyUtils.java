package pers.wmx.utils;

import java.util.Scanner;

/**
 * 工具类
 *
 * @author: wangmingxin1
 * @create: 2018-10-19 17:54
 **/
public class MyUtils {
    public static Scanner in =new Scanner(System.in);

    /*public static int generateNum(){
        System.out.println("输入一个数据：");
        int num =in.nextInt();
        return num;
    }*/

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int min(int a,int b){
        return a<b?a:b;
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }
}
