package pers.wmx.leetcode;

import pers.wmx.utils.MyUtils;

/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a contiguous subarray （连续的子串） of which the sum ≥ s.
If there isn't one, return 0 instead.

Example:
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
*
* */
public class LeetCode_209_MinimumSizeSubarraySum {

    //显然暴力法，时间复杂度太高
    //使用2个指针  滑动窗口
    //时间复杂度O（n）
    public int minSubArrayLen(int s, int[] nums) {
        int l=0;
        int r=-1;  //[l,r]区域为滑动窗口，起初 r=-1,窗口内没有值
        int sum=0;
        int result=nums.length+1;  //初始化为数组的长度再加1

        while(l<nums.length){
            if(r+1<nums.length && sum < s){
                sum+=nums[++r];
            }else{
                sum-=nums[l++];
            }

            if(sum>=s){
                result=MyUtils.min(result,r-l+1);
            }
        }

        if(result == nums.length+1){
            return 0;
        }

        return result;

    }

}
