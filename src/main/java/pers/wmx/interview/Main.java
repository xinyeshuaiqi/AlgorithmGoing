package pers.wmx.interview;

/**
 * @author wmx
 * @date 2020-02-25
 *
 * 算法实现：
 * 在大文本中查找最长的回文串（至少2个字符，该字符串反序之后同原字符串一样），
 * 并返回（如果没有返回Null）【测试用例：aaabbaccbababac，返回babab】。
 */
public class Main {

    public static void main(String[] args) {
        String str = "aaabbaccbababac";
        String result = findStr(str);
        System.out.println(result);
    }

    /**
     * 最长回文字符串
     * 
     * @param input
     * @return String
     * @throws
     */
    public static String findStr(String input){
        int i = 0;
        int j = input.length()-1;
        return hasStr(input,i,j);
    }

    /**
     * 递归调用查找回文字符串
     * 
     * @param str
     * @param i
     * @param j
     * @return String
     * @throws
     */
    private static String hasStr(String str, int i, int j) {

        if( i == j){
            return null;
        }

        // i - j 的字符串
        String tempStr = str.substring(i,j+1);
        // i - j 的字符串【逆序】
        String reverseStr = getReverse(tempStr);

        if (tempStr.equals(reverseStr)){
            return tempStr;
        }else{
            hasStr(tempStr,++i,j);
            hasStr(tempStr,i,--j);
        }

        return null;
    }

    /**
     * 字符串逆序
     *
     * @param str
     * @return String
     * @throws
     */
    private static String getReverse(String str) {
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int j = chars.length - 1 ; j >= 0 ; j -- ) {
            stringBuffer.append(chars[j]);
        }
        return stringBuffer.toString();
    }


}
