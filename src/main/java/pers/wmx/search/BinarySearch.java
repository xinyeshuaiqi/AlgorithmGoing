package pers.wmx.search;

import pers.wmx.utils.MyUtils;

/**
 * 二分查找   (前提：有序数组)
 *
 * @author: wangmingxin1
 * @create: 2018-10-25 11:51
 **/
public class BinarySearch {
    public static int binarySearch(int []arr,int key){
        int low=0;
        int high=arr.length-1;

        // 注意：这里必须是 <=
        while(low <= high) {
            int mid = (low + high) / 2;
            if(key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                high=mid -1;
            }else if(key > arr[mid]){
                low =mid +1;
            }
        }

        return -1;
    }

    public static int binarySearch(int []arr,int key,int low,int high){

        // 注意：这里必须是 <=
        while(low <= high) {
            int mid = (low + high) / 2;
            if(key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                high=mid -1;
            }else if(key > arr[mid]){
                low =mid +1;
            }
        }

        return -1;
    }

    //mid = (low + high) / 2;  这样求mid是有问题的  -----> 整数溢出
    //使用减法来求  mid = low+(high-low)/2;
    public static int binarySearch1(int []arr,int key){
        int low=0;
        int high=arr.length-1;

        // 注意：这里必须是 <=
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                high=mid -1;
            }else if(key > arr[mid]){
                low =mid +1;
            }
        }

        return -1;
    }

    /*
    * 关于二分查找，如果条件稍微变换一下，
    * 比如：数组之中的数据可能可以重复，要求返回匹配的数据的最小（或最大）的下标；
    * 更近一步， 需要找出数组中第一个大于key的元素（也就是最小的大于key的元素的）下标，等等。
    * */

    //查找第一个与key相等的元素
    public static int findFirstEqual(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low+(high-low)/2;
            if (arr[mid] >= key) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if (low < arr.length && arr[low] == key) {
            return low;
        }
        return -1;
    }

    //查找最后一个与key相等的元素
    public static int findLastEqual(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low+(high-low)/2;
            if (arr[mid] > key) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if (high >=0  && arr[high] == key) {
            return high;
        }
        return -1;
    }


    public static void main(String[] args){
        int []arr={1,2,6,7,9,11,23,46,89};
        int key=MyUtils.in.nextInt();

        int index = binarySearch(arr, key);
        if(index==-1){
            System.out.println("查找失败 - > 不存在这个元素");
        }else{
            System.out.println("查找成功 - > 该元素"+key+"在数组中的位置为："+index);
        }

        int index1 = binarySearch(arr, 23,4,7);
        System.out.println("index1:"+index1);
    }
}
