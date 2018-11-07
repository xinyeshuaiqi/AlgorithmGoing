package pers.wmx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-07 14:48
 **/
public class LeetCode_77_Combinations {
    List<List<Integer>> result = new ArrayList<>();

    private void getCombinations(int n, int k, int start, List<Integer> list) {
        if(k== list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n ; i++) {
            list.add(i);
            getCombinations(n,k,i+1,list);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        if(n<=0 || k<=0 || k>n)
            return result;

        List<Integer> list = new ArrayList<>();

        getCombinations(n,k,1,list);

        return result;
    }


}
