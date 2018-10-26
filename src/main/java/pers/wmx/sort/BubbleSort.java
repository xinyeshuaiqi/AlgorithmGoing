package pers.wmx.sort;

import pers.wmx.utils.MyUtils;

/**
 * 冒泡排序
 * 每一趟出来一个最大的数（冒出一个泡泡）
 *
 * 时间复杂度： O（n^2）
 * 空间复杂度： O（1）
 * 冒泡排序是稳定的排序
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:22
 **/
public class BubbleSort {
    public static void bubbleSort(int []arr){
        for(int i=0;i<arr.length-1;i++){      //一共n-1躺排序（n个数需要n-1躺排序）  每一趟冒出来一个最大的数
            for(int j=0;j<arr.length-1-i;j++){
            //每过一趟排序，j的遍历范围缩减1  （最右边的坑已经被最大的数给占了，现在第二大的数准备入从右往左数的第二个坑...）
                if(arr[j]>arr[j+1]){
                    MyUtils.swap(arr,j,j+1);
                }
            }
        }
    }
}
