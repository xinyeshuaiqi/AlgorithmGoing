package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_350_IntersectionofTwoArraysII;

/**
 * @author: wangmingxin1
 * @create: 2018-10-29 10:50
 **/
public class testLeetCode_350_IntersectionofTwoArraysII {

    private static LeetCode_350_IntersectionofTwoArraysII leetCode_350_IntersectionofTwoArraysII=new LeetCode_350_IntersectionofTwoArraysII();

    @Test
    public void testIntersect(){
        int []nums1={1,2,2,1};
        int []nums2={2,2};

        int[] intersection = leetCode_350_IntersectionofTwoArraysII.intersect(nums1, nums2);
        for (int a: intersection) {
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");

        int []nums3={4,9,5};
        int []nums4={9,4,9,8,4};

        int[] intersection1 = leetCode_350_IntersectionofTwoArraysII.intersect(nums3, nums4);
        for (int a: intersection1) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
