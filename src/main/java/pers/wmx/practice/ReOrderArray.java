package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-06-23
 */
public class ReOrderArray {

    //不要使用新数组
//    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
//    所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }

        int last = -1;
        for (int i = 0; i < length; i++) {
            if(array[i]%2 != 0){
                //奇数
                int newOdd = array[i];

                for (int j = i-1; j > last; j--) {
                    array[j + 1] = array[j];
                }

                //last记录可以填充的前半部分的index
                array[last+1] = newOdd;
                last++;
            }
        }

    }

}
