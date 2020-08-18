package pers.wmx.practice;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.ImmutableList;

/**
 * @author: wangmingxin03
 * @date: 2020-08-17
 */
public class ContinuousListTest {

    public static void main(String[] args) {
        List<Integer> nums = ImmutableList.of(2, 3, 4, 5, 6);
        System.out.println(isContinuous1(nums));
        System.out.println(isContinuous2(nums));

        List<Integer> nums1 = ImmutableList.of(2, 3, 4, 5, 6, 9, 10);
        System.out.println(isContinuous1(nums1));
        System.out.println(isContinuous2(nums1));
    }

    public static boolean isContinuous1(List<Integer> nums) {

        AtomicBoolean continuous = new AtomicBoolean(true);
        AtomicInteger counter = new AtomicInteger(nums.get(0));
        nums.forEach(item -> {
            if (counter.getAndIncrement() != item) {
                continuous.set(false);
            }
        });

        return continuous.get();
    }

    public static boolean isContinuous2(List<Integer> nums) {
        AtomicInteger counter = new AtomicInteger(nums.get(0));
        return nums.stream().allMatch(i -> i == counter.getAndIncrement());
    }
}
