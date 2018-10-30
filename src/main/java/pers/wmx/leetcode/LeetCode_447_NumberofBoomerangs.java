package pers.wmx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 17:32
 **/
public class LeetCode_447_NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int result =0;

        for (int i = 0; i <points.length ; i++) {
            Map<Integer,Integer> record = new HashMap<>();

            for (int j = 0; j <points.length ; j++){
                if(i!=j){
                    int distance = dis(points[i],points[j]);
                    record.put(distance, record.getOrDefault(distance, 0) + 1);
                }
            }
            for (Integer value : record.values()) {
                result+=value*(value-1);
            }
        }

        return result;
    }

    public int dis(int[] p1, int[] p2) {
        return (int) (Math.pow((p2[0]-p1[0]),2)+Math.pow((p2[1]-p1[1]),2));
    }
}
