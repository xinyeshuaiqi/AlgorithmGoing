package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_75_SortColors;

/**
 * @author: wangmingxin1
 * @create: 2018-10-26 14:52
 **/
public class testLeetCode_75_SortColors {
    private static LeetCode_75_SortColors leetCode_75_SortColors=new LeetCode_75_SortColors();

    @Test
    public void testSortColors1(){
        int []arr={2,0,2,1,1,0};
        leetCode_75_SortColors.sortColors1(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }

    @Test
    public void testSortColors2(){
        int []arr={2,0,2,1,1,0};
        leetCode_75_SortColors.sortColors2(arr);
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
}
