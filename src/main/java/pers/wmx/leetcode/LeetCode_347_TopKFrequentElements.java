package pers.wmx.leetcode;

import java.util.*;

/**
 * iven a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author: wangmingxin1
 * @create: 2018-11-06 11:10
 **/
public class LeetCode_347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result =new ArrayList<>();
        Map<Integer,Integer> record =new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            record.put(nums[i],record.getOrDefault(nums[i],0)+1);
        }

        //优先队列   大顶堆
        Queue<Map.Entry> queue =new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                int i = (int) o2.getValue() - (int) o1.getValue();
                return i;
            }
        });

        Iterator entries = record.entrySet().iterator();
        int count =0;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            queue.add(entry);
        }

        while(!queue.isEmpty()){
            Map.Entry entry = queue.poll();
            result.add((Integer) entry.getKey());
            count++;
            if(count==k){
                break;
            }
        }

        return result;
    }
}
