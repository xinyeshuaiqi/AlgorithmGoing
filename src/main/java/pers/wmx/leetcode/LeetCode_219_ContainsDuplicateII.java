package pers.wmx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the absolute difference between i and j is at most k.
 *
 * Example 1:s
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 18:07
 **/
public class LeetCode_219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> record = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!record.containsKey(nums[i])){
                record.put(nums[i],i);
            }else{
                Integer index = record.get(nums[i]);
                if(Math.abs(index-i) <= k){
                    return true;
                }else{
                    record.put(nums[i],i);
                }
            }
        }

        return false;
    }

}
