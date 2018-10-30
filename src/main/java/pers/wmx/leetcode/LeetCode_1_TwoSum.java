package pers.wmx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 16:48
 **/
public class LeetCode_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int []result =new int[2];
        //使用一个Map来存放数据 + 对应的下标
        Map<Integer, Integer> map =new HashMap();

        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                result[0]=i;
                result[1]=map.get(target-nums[i]);
                return result;
            }else{
                map.put(nums[i],i);
            }
        }

        return null;
    }
}
