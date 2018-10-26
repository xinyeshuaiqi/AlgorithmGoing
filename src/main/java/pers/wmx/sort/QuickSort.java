package pers.wmx.sort;

/**
 * 时间复杂度 O（nlogn）
 * 快速排序不是稳定的排序
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:30
 **/
public class QuickSort {
    public static int partition(int []a,int low,int high){
        int i=low;
        int j=high;
        int key=a[low];

        while (i<j){
            while(i<j&&a[j]>=key){
                j--;
            }
            a[i]=a[j];   //a[j]<pivotkey
            while(i<j&&a[i]<=key){
                i++;
            }
            a[j]=a[i];	//a[j]>pivotkey
        }
        a[i]=key;
        return i;
    }

    public static void quickSort(int []a,int low,int high){
        if(low<high){
            int keyLocation=partition(a,low,high); //找到中轴
            quickSort(a,low,keyLocation-1);     //对中轴左边的排序
            quickSort(a,keyLocation+1,high);    //对中轴右边的排序
        }else {
            return;
        }
    }
}
