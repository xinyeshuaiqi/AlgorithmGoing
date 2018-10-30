package pers.wmx.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-30 17:01
 **/
public class LeetCode_454_4SumII {

    //如果直接暴力法，O(n^4),显然不可行

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        //我们把C和D的数组相加的结果的所有可能存在一个Map中
        //在双层循环遍历A和B数组，在Map寻找可能的解，这样做时间复杂度被压缩到了O(n^2)

        Map<Integer,Integer> record= new HashMap<>();
        for (int i = 0; i <C.length ; i++) {
            for (int j = 0; j <D.length ; j++) {
                int sum =C[i]+D[j];
                if(!record.containsKey(sum)){
                    record.put(sum,1);
                }else {   //如果用于记录的Map已经存在这种合的情况，就把出现的频次+1
                    Integer frequence = record.get(sum);
                    frequence++;
                    record.put(sum,frequence);
                }
            }
            
        }

        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j <B.length ; j++) {
                int sum =A[i]+B[j];
                int need = 0-sum;   //我们需要的是和sum相加为0，即这个数等于0-sum
                if(record.containsKey(need)){
                    Integer frequence = record.get(need);
                    result+=frequence;
                }
            }

        }

        return result;
    }


    //我们发现这样写比较复杂，我们每次还要判断key在map中是否存在
    //算法效率也不理想，看了其他提交的代码，发现了一个牛逼的方法  getOrDefault(Object, V)  jdk8实现的方法
    //利用这个API，我们的算法可以大大优化
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer,Integer> record= new HashMap<>();

        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < B.length; j ++) {
                int sum = A[i] + B[j];
                record.put(sum, record.getOrDefault(sum, 0) + 1);   //如果存在这个键就返回这个键的值并加1，如果不存在就返回默认值0并加1
            }
        }

        for (int i = 0; i < C.length; i ++) {
            for (int j = 0; j < D.length; j ++) {
                int sum = C[i] + D[j];
                result += record.getOrDefault(-sum, 0);
            }
        }

        return result;
    }

}
