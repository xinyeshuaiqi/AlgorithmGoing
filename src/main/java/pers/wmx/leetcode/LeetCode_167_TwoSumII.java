package pers.wmx.leetcode;

import pers.wmx.search.BinarySearch;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 15:52
 **/
public class LeetCode_167_TwoSumII {

    /*可以使用暴力法，但复杂度为O（n^2）
    * 本题数组是有序的，可不可以根据这点来下功夫
    *
    * */

    //有序可以利用二分查找，确定一个下标，再下标右边的元素中使用二分查找来找到这个数 num = target - numbers[i]
    public int[] twoSum1(int[] numbers, int target) {
        int result[]=new int[2];
        int temp=0;
        for (int i=0;i<numbers.length;i++){
            temp = target - numbers[i];
            //在[i+1,numbers.length-1]这个区域里使用二分查找，定位temp，使得temp + numbers[i] = target;
            int low = i+1;
            int high = numbers.length- 1;
            int j = BinarySearch.binarySearch(numbers, temp,low,high);
            if(j!=-1){
                result[0]=i+1;
                result[1]=j+1;
            }
        }
        return result;
    }

    //使用对撞指针
    public int[] twoSum2(int[] numbers, int target) {
        int result[]=new int[2];
        int i=0;
        int j=numbers.length-1;

        while(i<j){
            if(numbers[i]+numbers[j]==target){
                result[0]=i+1;
                result[1]=j+1;
                break;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
