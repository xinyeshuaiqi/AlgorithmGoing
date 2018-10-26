package pers.wmx.leetcode;

import pers.wmx.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * 给一个数组，把所有的0移到数组的最后面，且保持数组中非零元素的相对位置不变
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 12:31
 **/
public class LeetCode_283_MoveZeroes {

    //版本1   牺牲空间 使用一个list来装非零元素，在用list的非零元素覆盖数组中原有元素后补零
    public  void moveZeroes1(int[] nums){
        List<Integer> list = new ArrayList();
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }

        for (int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        for (int i=list.size();i<nums.length;i++){
            nums[i]=0;
        }
    }

    //版本2  不需要额外的数组或集合  定义一个指针k
    public  void moveZeroes2(int[] nums){
        int k=0; // [0,k)为非零元素
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        //把nums剩余位置补0
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }

    //版本3 我们再来修改下，把nums[k]=nums[i];这里改成swap交换，这样就可以省去最后的补零操作
    public  void moveZeroes3(int[] nums){
        int k=0; // [0,k)为非零元素
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                MyUtils.swap(nums,k,i);
                k++;
            }
        }
    }

    //版本4
    /*
    *  试想如果nums[i]!=0时，但是i==k，岂不是自身和自身的交换，没有必要，所以新增一个判断条件
    *  if( i != k)
    * */
    public void moveZeroes4(int[] nums){
        int k=0; // [0,k)为非零元素
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(i!=k) {
                    MyUtils.swap(nums, k, i);
                    k++;
                }else   //如果i == k的话不执行交换操作
                    k++;
            }
        }
    }

}
