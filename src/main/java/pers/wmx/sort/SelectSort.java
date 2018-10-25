package pers.wmx.sort;

import pers.wmx.utils.MyUtils;

/**
 * 选择排序
 * 时间复杂度： O（n^2）
 * 选择排序不是稳定的排序
 *
 * @author: wangmingxin1
 * @create: 2018-10-25 12:45
 **/
public class SelectSort {
    public static void selectSort(int []arr){
        for(int i=0;i<arr.length;i++){              //i来控制遍历的范围   在该范围下选择一个最小的数
            int minIndex =i;           //当前遍历范围的最小值的下标
            for(int j= i+1;j<arr.length;j++){       //找出一个最小的数放在minIndex的位置上
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            MyUtils.swap(arr,i,minIndex); //确定一个最小的只交换一次
        }

    }

    public static void main(String[] args){
        int []arr={5,1,6,2,4,7};
        System.out.println("排序前的数组：");
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();

        selectSort(arr);

        System.out.println("排序后的数组：");
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
