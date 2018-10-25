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

    public static void main(String[] args){
        int []arr={1,2,6,7,9,11,23,46,89};
        int key=MyUtils.in.nextInt();

        int index = binarySearch(arr, key);
        if(index==-1){
            System.out.println("查找失败 - > 不存在这个元素");
        }else{
            System.out.println("查找成功 - > 该元素"+key+"在数组中的位置为："+index);
        }
    }
}
