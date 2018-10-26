package pers.wmx.sort;

import pers.wmx.utils.MyUtils;

/**
 * 插入排序
 * O（n^2）
 * 插入排序是稳定的排序
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:25
 **/
public class InsertSort {
    public static void insertSort(int []arr){
        for (int i = 1; i < arr.length; i++) {   //考虑的当前数i   往前面有序区插入(0  到 i-1)
            for (int j = i-1; j >=0 ; j--) {      //位置i的前一个数
                if(arr[j]>arr[j+1]){
                    MyUtils.swap(arr,j,j+1);
                }
            }
        }
    }
}
