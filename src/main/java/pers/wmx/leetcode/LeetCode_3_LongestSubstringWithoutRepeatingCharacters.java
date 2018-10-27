package pers.wmx.leetcode;


import pers.wmx.utils.MyUtils;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*
* */
public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {

    //字符串包含所有的ASCII码（256个）
    public int lengthOfLongestSubstring(String s) {
        //存放字符出现的次数
        int []freq= new int[256];
        int l=0;
        int r=-1; //[l,r]区域为滑动窗口，起初 r=-1,窗口内没有值

        int result=0;

        while(l<s.toCharArray().length){
            if(r+1<s.toCharArray().length && freq[s.charAt(r+1)]==0 ){
                r++;
                freq[s.charAt(r)]++;  //没有出现重复的，右指针一直往右移，左指针不动（子串增长）
            }else{
                freq[s.charAt(l)]--;  //出现重复的，右指针不动，左指针右移（子串变短）
                l++;
            }

            result = MyUtils.max(result,r-l+1);
        }

        return result;
    }
}
