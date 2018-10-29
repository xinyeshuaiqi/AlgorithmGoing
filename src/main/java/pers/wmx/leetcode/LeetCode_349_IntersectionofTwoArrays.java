package pers.wmx.leetcode;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-29 10:25
 **/
public class LeetCode_349_IntersectionofTwoArrays {

    //这样写好麻烦！
    public int[] intersection(int[] nums1, int[] nums2) {

        //用set的目的是避免重复元素
        Set<Integer> tempSet=new HashSet<>();
        Set<Integer> resultSet=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            tempSet.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++){
            if(tempSet.contains(nums2[i])){
                resultSet.add(nums2[i]);
            }
        }

        Integer[] integers = resultSet.toArray(new Integer[resultSet.size()]);
        //Integer类型数组转换为int数组
        int []result= Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return  result;
    }
}
