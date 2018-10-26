package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_88_MergeSortedArray;

/**
 * @author: wangmingxin1
 * @create: 2018-10-26 15:32
 **/
public class testLeetCode_88_MergeSortedArray {
    private static LeetCode_88_MergeSortedArray leetCode_88_MergeSortedArray = new LeetCode_88_MergeSortedArray();

    @Test
    public void testMerge(){
        int []nums1={1,2,3,0,0,0};
        int m=3;
        int []nums2 ={2,5,6};
        int n=3;

        leetCode_88_MergeSortedArray.merge(nums1,m,nums2,n);

        System.out.println("合并后：");
        for(int a : nums1){
            System.out.print(a+" ");
        }

    }
}
