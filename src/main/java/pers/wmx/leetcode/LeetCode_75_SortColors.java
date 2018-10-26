package pers.wmx.leetcode;

import pers.wmx.utils.MyUtils;

/**
 * https://leetcode.com/problems/sort-colors/description/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * 其实可以看成荷兰国旗问题
 * http://xinyeshuaiqi.cn/2018/08/27/%E7%AE%97%E6%B3%95%E5%9B%9E%E9%A9%AC%E6%9E%AA%E4%B9%8B%E8%8D%B7%E5%85%B0%E5%9B%BD%E6%97%97/
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 14:47
 **/
public class LeetCode_75_SortColors {

    /*
    * 首先这不是一个普通的排序问题，用普通的排序算法显然不是这题的考点
    * 要充分利用他的条件： 只有3种数 0，1，2
    *
    * 可以分为3个区域：0的区域，1的区域，2的区域，即小于1的区域，等于1的区域，大于1的区域
    *
    *
    * */

    //这里可以使用计数排序  但是这样写相当于遍历了2次
    public void sortColors1(int[] nums) {
        int []count = {0,0,0};  //创建一个容量为3的数组，分别装0、1、2在nums中出现的次数

        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        int index=0;
        for(int i=0;i<count[0];i++){
            nums[index]=0;
            index++;
        }
        for(int i=0;i<count[1];i++){
            nums[index]=1;
            index++;
        }
        for(int i=0;i<count[2];i++){
            nums[index]=2;
            index++;
        }
    }

    //借助于2个指针
    //时间的复杂度O(n)   遍历一遍
    public void sortColors2(int[] nums) {
        int less=-1;  //[0,less]区域小于1，在本题即为0
        int more=nums.length; //[more,nums.length-1]区域大于1，在本题即为2

        for(int i=0;i<more;){
            if(nums[i]==0){
                less++;
                MyUtils.swap(nums,less,i);
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                more--;
                MyUtils.swap(nums,more,i);
            }
        }
    }
}
