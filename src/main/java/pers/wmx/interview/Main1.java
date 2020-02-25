package pers.wmx.interview;

/**
 * @author wmx
 * @date 2020-02-25
 *
 * 算法实现：
 *  * 在大文本中查找最长的回文串（至少2个字符，该字符串反序之后同原字符串一样），
 *  * 并返回（如果没有返回Null）【测试用例：aaabbaccbababac，返回babab】。
 */
public class Main1 {

    public static void main(String[] args) {
        String str = "aaabbaccbababac";
        String result = findStr(str);
        System.out.println(result);
    }

    /**
     * 求最长的回文串
     *
     * @param str
     * @return String
     * @throws
     */
    public static String findStr(String str) {

        //参数校验
        if (str == null || str.length() == 0 || str.length() == 1) {
            return null;
        }

        //初始化结果
        int maxLen = 1;
        String res = str.substring(0, 1);

        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < str.length() - 1; i++) {

            //基数个回文串 如 aba
            String  oddStr= centerSpread(str, i, i);

            //偶数个回文串 如 aa
            String evenStr = centerSpread(str, i, i + 1);

            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                //重置结果
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    /**
     * 从中心向两边扩
     *
     * left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
     * right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
     *
     * @param str
     * @param left
     * @param right
     * @return String
     * @throws
     */
    private static String centerSpread(String str, int left, int right) {
        int len = str.length();
        int i = left;
        int j = right;
        //从中间向两边扩
        while (i >= 0 && j < len) {
            if (str.charAt(i) == str.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return str.substring(i + 1, j);
    }

}
