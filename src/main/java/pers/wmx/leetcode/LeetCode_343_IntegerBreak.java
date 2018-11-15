package pers.wmx.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.

 Example 1:
 Input: 2
 Output: 1
 Explanation: 2 = 1 + 1, 1 × 1 = 1.

 Example 2:
 Input: 10
 Output: 36
 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

 Note: You may assume that n is not less than 2 and not larger than 58.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-15 11:40
 **/
public class LeetCode_343_IntegerBreak {
    public int integerBreak(int n) {
        int []record = new int[n+1];  //记录最大乘积
        Arrays.fill(record,-1);

        return breakProduct(n,record);
    }

    //Time Limit Exceeded
    //数字n拆分后最大乘积
    private int breakProduct(int n, int[] record) {
        if(n==1){
            return 1;
        }

        if(record[n]!=-1){
            return record[n];
        }

        int result=-1;
        for (int i = 1; i <= n ; i++) {
            result = Math.max(Math.max(result,i*(n-i)),i*breakProduct(n-i,record));
        }

        return result;
    }


    private int breakProduct1(int n, int[] record) {
        record[1] = 1;

        if(record[n] != -1){
            return record[n];
        }

        //record[i]
        //拆分成  j 和 i-j
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                record[i] = Math.max(Math.max(record[i],j*(i-j)), j*record[i-j]);
            }
        }

        return record[n];
    }
}
