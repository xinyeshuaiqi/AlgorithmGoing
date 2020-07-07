package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-07-07
 */
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int []arr = {1,2,3,2,2,2,5,4,2};

        int moreThanHalfNum = findMoreThanHalfNum(arr);
        System.out.println(moreThanHalfNum);
    }

    public static int findMoreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int preValue = array[0];
        int count = 1;

        for (int i = 1; i < array.length ; i++) {
            if (preValue == array[i]) {
                count ++;
            } else {
                if (count == 1) {
                    preValue = array[i];
                } else {
                    count --;
                }
            }
        }

        //一一抵消，如果存在大于数组长度一半的数，最后剩下的肯定是这个

        //还需要校验一下，最终的数出现次数是否超过数组的一半
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (preValue == array[i]) {
                times ++;
            }
        }

        if (times > array.length / 2) {
            return preValue;
        }

        return -1;
    }
}
