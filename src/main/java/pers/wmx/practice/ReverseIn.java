package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-08-12
 */
public class ReverseIn {

    public static void main(String[] args) {
        System.out.println(reverse(100000));
        System.out.println(reverse(123456));

        System.out.println(reverse(1200045600));
        System.out.println(reverse(1111199999));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    public static int reverse(int i) {
        if (i == 0) {
            return 0;
        }

        int maxValue = Integer.MAX_VALUE;

        if (i < -1) {
            i = i * -1;
        }

        String str = String.valueOf(i);
        String reverseStr = new StringBuilder(str).reverse().toString();

        String[] splitNum = reverseStr.split("");
        int numLength = splitNum.length;

        //溢出
        if (numLength > 10) {  //int类型不会超过10位 编译不通过
            return 0;
        }

        if (numLength == 10) {
            int compare = reverseStr.compareTo(String.valueOf(maxValue));
            //溢出
            if (compare > 0) {
                return 0;
            }
        }

        return Integer.parseInt(reverseStr);
    }

}
