package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-29 10:25
 **/
public class LeetCode_350_IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        int []result=null;

        List<Integer> tempResult =new ArrayList();
        Map<Integer, Integer> map =new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else{
                Integer integer = map.get(nums1[i]);
                integer++;
                map.put(nums1[i],integer);
            }
        }
        for (int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                tempResult.add(nums2[i]);
                Integer integer = map.get(nums2[i]);
                integer--;
                map.put(nums2[i],integer);
            }
        }
        result=new int[tempResult.size()];
        for (int i=0;i<tempResult.size();i++){
            result[i]=tempResult.get(i);
        }
        return result;
    }
}
