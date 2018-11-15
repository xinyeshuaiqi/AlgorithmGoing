package pers.wmx.leetcode;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-15 11:16
 **/
public class LeetCode_70_ClimbingStairs {

    //Time Limit Exceeded
    public int climbStairs(int n) {
        //int []record = new int[n+1];
        return climb(n);
    }

    private int climb(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        return climb(n-1)+climb(n-2);
    }

    //------------------------------------------
    public int climbStairs1(int n) {
        int []record = new int[n+1];
        Arrays.fill(record,-1);
        return climb1(n,record);
    }

    //自底向上
    private int climb1(int n, int[] record) {
        record[0]=1;
        record[1]=1;

        if(record[n]!=-1){
            return record[n];
        }

        for (int i = 2; i <= n; i++) {
            record[i] = record[i-1]+record[i-2];
        }

        return record[n];
    }


}
