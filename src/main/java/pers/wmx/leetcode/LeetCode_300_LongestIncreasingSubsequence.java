package pers.wmx.leetcode;

import java.util.Arrays;

/**
 *
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 Example:
 Input: [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

 Note:
 There may be more than one LIS combination, it is only necessary for you to return the length.
 Your algorithm should run in O(n2) complexity.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-23 09:51
 **/
public class LeetCode_300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int [] record = new int[nums.length];

        Arrays.fill(record,1);   //初始化为1，表示自己本身就是1个长度为1的子序列

        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j < i; j++) {    //遍历i之前的数，得到他们的record
                if(nums[i]>nums[j]) {
                    record[i] = Math.max(record[i], 1 + record[j]);
                }
            }
        }

        int result = 1;
        for (int i = 0; i <nums.length ; i++) {
            result = Math.max(result,record[i]);
        }

        return result;
    }
}
