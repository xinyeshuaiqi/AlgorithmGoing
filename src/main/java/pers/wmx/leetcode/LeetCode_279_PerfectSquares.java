package pers.wmx.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 Example 1:
 Input: n = 12
 Output: 3
 Explanation: 12 = 4 + 4 + 4.

 Example 2:
 Input: n = 13
 Output: 2
 Explanation: 13 = 4 + 9.

 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-06 10:16
 **/
public class LeetCode_279_PerfectSquares {
    public int numSquares(int n) {
        Queue<Record> queue = new LinkedList<>();
        queue.add(new Record(n,0));

        boolean []visited = new boolean[n+1];
        Arrays.fill(visited,false);
        visited[visited.length-1]=true;

        while(!queue.isEmpty()){
            Record r = queue.poll();
            int num = r.num;
            int step = r.step;

            if(num == 0)
                return step;

            for (int i = 1; num-i*i >=0 ; i++) {
                if(!visited[num-i*i]){
                    queue.add(new Record(num-i*i,step+1));
                    visited[num-i*i]=true;
                }
            }
        }

        return -1;
    }
}

class Record{
    int num;
    int step;

    public Record(int num,int step){
        this.num=num;
        this.step=step;
    }
}
