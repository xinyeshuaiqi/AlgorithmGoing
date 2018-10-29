package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_349_IntersectionofTwoArrays;

/**
 * @author: wangmingxin1
 * @create: 2018-10-29 10:44
 **/
public class testLeetCode_349_IntersectionofTwoArrays {

    private static LeetCode_349_IntersectionofTwoArrays leetCode_349_IntersectionofTwoArrays =new LeetCode_349_IntersectionofTwoArrays();
    /* Example 1:
    * Input: nums1 = [1,2,2,1], nums2 = [2,2]
    * Output: [2]
    *
    * Example 2:
    * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    * Output: [9,4]
    * */
    @Test
    public void testIntersection(){
        int []nums1={1,2,2,1};
        int []nums2={2,2};

        int[] intersection = leetCode_349_IntersectionofTwoArrays.intersection(nums1, nums2);
        for (int a: intersection) {
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");

        int []nums3={4,9,5};
        int []nums4={9,4,9,8,4};

        int[] intersection1 = leetCode_349_IntersectionofTwoArrays.intersection(nums3, nums4);
        for (int a: intersection1) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
