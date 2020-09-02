package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-09-02
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(6));
        System.out.println(isPalindrome(88));
        System.out.println(isPalindrome(8118));
        System.out.println(isPalindrome(861168));
        System.out.println(isPalindrome(1234567));
        System.out.println(isPalindrome(76543567));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        int div = 1;

        //找出x的最高位
        while (x/div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            //读取最高位
            int left = x / div;

            //读取最低位
            int right = x % 10;

            if (left != right) {
                //说明不是回文数
                return false;
            }

            //去掉x的最高位和最低位
            x = (x % div) / 10;  //比如 8118 经过 计算干掉最高位和最低位就是11

            //干掉了2位，div/100
            div = div / 100;
        }

        return true;
    }
}
