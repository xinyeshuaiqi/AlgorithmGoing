package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_167_TwoSumII;

/**
 * @author: wangmingxin1
 * @create: 2018-10-26 15:55
 **/
public class testLeetCode_167_TwoSumII {
    private static LeetCode_167_TwoSumII  leetCode_167_TwoSumII = new LeetCode_167_TwoSumII();

    @Test
    public void testTwoSum1(){
        int []a = {2,7,11,15};
        int[] result = leetCode_167_TwoSumII.twoSum1(a, 18);
        System.out.println("index1:"+result[0]+",index2:"+result[1]);
    }

    @Test
    public void testTwoSum2(){
        int []a = {2,7,11,15};
        int[] result = leetCode_167_TwoSumII.twoSum2(a, 22);
        System.out.println("index1:"+result[0]+",index2:"+result[1]);
    }

}
