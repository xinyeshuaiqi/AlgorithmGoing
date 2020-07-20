package pers.wmx.practice;

/**
 * @author: wangmingxin03
 * @date: 2020-07-20
 */
public class Plus1 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] plus1 = plus(nums1);
        for (int i = 0; i < plus1.length ; i++) {
            System.out.print(plus1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {9, 9, 9};
        int[] plus2 = plus(nums2);
        for (int i = 0; i < plus2.length ; i++) {
            System.out.print(plus2[i] + " ");
        }
    }

    public static int[] plus (int nums[]) {
        for (int i = nums.length - 1; i >= 0 ; i--) {
            nums[i] ++;

            //没有产生进位 直接return
            if(nums[i] % 10 != 0) {
                return nums;
            }
        }

        nums = new int[nums.length + 1];
        nums[0] = 1;

        return nums;
    }

}
