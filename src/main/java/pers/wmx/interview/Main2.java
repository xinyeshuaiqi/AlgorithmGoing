package pers.wmx.interview;

/**
 * @author wmx
 * @date 2020-02-25
 */
public class Main2 {

    public String findStr(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            // 由于回文有两种
            // 一种是 aba，另一种是 abba，所以需要通过下面两步去进行寻找
            int len1 = hasStr(s, i, i);
            int len2 = hasStr(s, i, i + 1);
            // 取出最长的回文
            int len = Math.max(len1, len2);
            // 计算回文长度，只留下最长的回文
            if (len > end - start + 1) {
                // 计算出开始位置
                start = i - (len - 1)/2;
                // 计算出结束位置
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int hasStr(String str, int left, int right) {
        // 越界检查，防止数组越界  判断字符是否相等
        while (left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            // 如果相等则判断下一个字母，一直判断到不想等的字母为止
            left--;
            right++;
        }
        // 由于最终比较后的结果，left 和 right 指向的字母必然是不想等的，通过 right - left - 1 计算
        // 出来的便是不包含 left 和 right 指向的字符串的长度
        return right - left - 1;
    }

}
