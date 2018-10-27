package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_3_LongestSubstringWithoutRepeatingCharacters;

public class testLeetCode_3_LongestSubstringWithoutRepeatingCharacters {
    private static LeetCode_3_LongestSubstringWithoutRepeatingCharacters leetCode_3_LongestSubstringWithoutRepeatingCharacters=
            new LeetCode_3_LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void testLengthOfLongestSubstring(){
        String s="abcabcbb";
        String s1="bbbbb";
        String s2="pwwkew";
        int result = leetCode_3_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        int result1 = leetCode_3_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s1);
        int result2 = leetCode_3_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s2);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }
}
