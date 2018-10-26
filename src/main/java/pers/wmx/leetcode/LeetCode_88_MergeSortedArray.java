package pers.wmx.leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array/description/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Input:
 *      nums1 = [1,2,3,0,0,0], m = 3
 *      nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 15:29
 **/
public class LeetCode_88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []help=new int[m+n]; //辅助数组
        int i=0;
        int j=0;
        int index=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                help[index]=nums1[i];
                index++;
                i++;
            }else{
                help[index]=nums2[j];
                index++;
                j++;
            }
        }
        while(i<m){
            help[index]=nums1[i];
            i++;
            index++;
        }
        while(j<n){
            help[index]=nums2[j];
            j++;
            index++;
        }

        for(int k=0;k<nums1.length;k++){
            nums1[k]=help[k];
        }
    }
}
