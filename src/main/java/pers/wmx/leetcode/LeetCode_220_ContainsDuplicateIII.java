package pers.wmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and
 * the absolute difference between i and j is at most k.

 Example 1:
 Input: nums = [1,2,3,1], k = 3, t = 0
 Output: true

 Example 2:
 Input: nums = [1,0,1,1], k = 1, t = 2
 Output: true

 Example 3:
 Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 Output: false
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 18:24
 **/
public class LeetCode_220_ContainsDuplicateIII {

    //暂时没有好的想法，先用暴力法做   然而这样写leetCode上通不过
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                if(i!=j){
                    if((long)Math.abs((long)nums[i]-(long)nums[j])<=(long)t && (long)Math.abs((long)i-(long)j)<=(long)k )
                        return true;
                }
            }
        }

        return false;
    }


    //借助自己的数据结构
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        List<Elment> list = new ArrayList<Elment>();
        for(int i=0;i<nums.length;i++){
            Elment ele = new Elment(i,nums[i]);
            list.add(ele);
        }
        Collections.sort(list,new Comparator<Elment>() {
            @Override
            public int compare(Elment o1, Elment o2) {
                long l = (long)o1.value - (long)o2.value;
                if(l == 0){
                    return 0;
                }
                else if(l<0){
                    return -1;
                }
                return 1;
            }
        });
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                long l = (long)list.get(i).value - (long)list.get(j).value;
                if(Math.abs(l) <= t){
                    if(Math.abs(list.get(i).index-list.get(j).index) <= k){
                        return true;
                    }
                }else{
                    break;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0) return false;

        int n = nums.length;
        Map<Long, Long> buckets = new HashMap<>();
        long window = (long)t + 1;
        for (int i = 0; i < n; i++) {
            long key = calKey((long)nums[i], window);
            if (buckets.containsKey(key)) return true; //two numbers in the same bucket
            if (buckets.containsKey(key-1) && ((long)nums[i] - buckets.get(key-1)) <= t) return true;
            if (buckets.containsKey(key+1) && (buckets.get(key+1)-(long)nums[i]) <= t) return true;
            buckets.put(key, (long)nums[i]);
            if (i >= k) buckets.remove(calKey((long)nums[i-k], window));
        }
        return false;
    }
    private long calKey(long num, long window) {
        return (num < 0)? ((num+1)/window - 1) : num/window;
    }

    @Test
    public void test(){
        int []nums={1,5,9,1,5,9};
        int k=2;
        int t=3;
        boolean flag = containsNearbyAlmostDuplicate1(nums, k, t);
        System.out.println(flag);
    }

}

class Elment{
    int index;
    int value;
    public Elment(int index,int value){
        this.index=index;
        this.value=value;
    }
}