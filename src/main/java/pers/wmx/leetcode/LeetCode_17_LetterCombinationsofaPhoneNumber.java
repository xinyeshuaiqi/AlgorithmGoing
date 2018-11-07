package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 Example:
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-07 10:54
 **/
public class LeetCode_17_LetterCombinationsofaPhoneNumber {
    List<String> result =  new ArrayList<>();

    //手机上数字和字符串的印射关系  输入范围2-9  0和1是为了方便角标统一
    String []maping={
            "",         //0
            "",         //1
            "abc",      //2
            "def",      //3
            "ghi",      //4
            "jkl",      //5
            "mno",      //6
            "pqrs",     //7
            "tuv",      //8
            "wxyz"      //9
    };

    public void generateCombinations(String digits, int index, String s){

        if(index == digits.length()){
            result.add(s);
            return;
        }

        char c = digits.charAt(index);
        String str = maping[c - '0'];

        for (int i = 0; i < str.length() ; i++) {
            generateCombinations(digits, index+1, s + str.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null || "".equals(digits)){
            return result;
        }

        String s = "";

        generateCombinations(digits,0,s);

        return result;
    }
}
