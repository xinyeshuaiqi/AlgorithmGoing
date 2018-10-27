package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_209_MinimumSizeSubarraySum;

public class testLeetCode_209_MinimumSizeSubarraySum {
    private static LeetCode_209_MinimumSizeSubarraySum leetCode_209_MinimumSizeSubarraySum =
            new LeetCode_209_MinimumSizeSubarraySum();

    /*
    * Example:
        Input: s = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
    */
    @Test
    public void testMinSubArrayLen(){
        int s=7;
        int []nums={2,3,1,2,4,3};

        int result = leetCode_209_MinimumSizeSubarraySum.minSubArrayLen(7, nums);
        System.out.println("大于"+s+"的最小子串的长度为"+result);
    }
}
