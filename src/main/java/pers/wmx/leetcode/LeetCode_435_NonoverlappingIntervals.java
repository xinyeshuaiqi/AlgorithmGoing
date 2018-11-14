package pers.wmx.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

 Example 1:
 Input: [ [1,2], [2,3], [3,4], [1,3] ]
 Output: 1
 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

 Example 2:
 Input: [ [1,2], [1,2], [1,2] ]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

 Example 3:
 Input: [ [1,2], [2,3] ]
 Output: 0
 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-09 16:56
 **/
public class LeetCode_435_NonoverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {

        //使用贪心算法  按照区间结尾排序
        //每次选择结尾最早的，且和前一个区间不重叠

        //可以移除多少个  ---- >   剩余多少个

        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {   //按照区间结尾升序排序
                if(o1.end > o2.end ) {
                    return 1;
                }else if(o1.end < o2.end){
                    return -1;
                }else{
                    return (o1.start >o2.start)? 1 : -1;
                }
            }
        });

        int count = 1;   //把第一个区间放进去
        int pre=0;
        for (int i = 1; i <intervals.length ; i++) {
            if(intervals[i].start >= intervals[pre].end ){
                count++;
                pre=i;
            }
        }

        return intervals.length - count;
    }
}

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}
