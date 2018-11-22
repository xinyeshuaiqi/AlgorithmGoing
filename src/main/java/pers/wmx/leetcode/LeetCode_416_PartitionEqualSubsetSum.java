package pers.wmx.leetcode;

/**
 *
 Given a non-empty array containing only positive integers,
 find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.

 Example 1:
 Input: [1, 5, 11, 5]
 Output: trues
 Explanation: The array can be partitioned as [1, 5, 5] and [11].

 Example 2:
 Input: [1, 2, 3, 5]
 Output: false
 Explanation: The array cannot be partitioned into equal sum subsets.

 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-22 11:13
 **/
public class LeetCode_416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int sum =0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }

        if(sum % 2 >0)   //如果不能被2整除，肯定不能分成2份
            return false;

        int n =nums.length;
        int C = sum/2;  //分成2份，表示数值一样
        boolean[] memo = new boolean[C + 1];

        for (int i = 0; i <=C ; i++) {
           //先填nums[0]这个数对应的行
            memo[i] = (nums[0] == i);
        }

        //考虑其他的数
        for (int i = 1; i < n; i++) {
            for (int j = C; j >=nums[i] ; j--) {
                memo[j] = memo[j] || memo[j-nums[i]];
            }
        }

        return memo[C];
    }
}
