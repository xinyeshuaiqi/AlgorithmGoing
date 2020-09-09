package pers.wmx.practice;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author: wangmingxin03
 * @date: 2020-09-09
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String prefix = longestCommonPrefix(ImmutableList.of("wx", "wm", "wmx", "wmxinye"));
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }

        if (strs.size() == 1) {
            return strs.get(0);
        }

        //先找出长度最小的
        int minLen = Integer.MAX_VALUE;
        String tempStr = "";
        for (String str : strs) {
            if (str.length() < minLen) {
                minLen = str.length();
                tempStr = str;
            }
        }

        int subStrLen = tempStr.length();
        while (subStrLen >= 1) {
            String finalTempStr = tempStr;
            boolean allContains = strs.stream()
                    .allMatch(str -> str.contains(finalTempStr));

            if (allContains) {
                return tempStr;
            }

            tempStr = tempStr.substring(0, tempStr.length() - 1);
            subStrLen --;
        }

        return "";
    }

}
