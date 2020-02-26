package pers.wmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given a collection of distinct integers, return all possible permutations.

 Example:
 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-07 11:27
 **/
public class LeetCode_46_Permutations {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public void generatePermute(int[] nums, int length, List<Integer> list, boolean[] used){

        //length表示的当前的list的长度
        if(length == nums.length){
            //我一开始这样写的： result.add(list);  答案死活出不来 ...
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                generatePermute(nums,length+1,list,used);
                //System.out.println(list.size()-1);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }

        return;

    }


    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return result;
        }

        //表示是否在排列中已经使用过
        boolean []used = new boolean[nums.length];
        Arrays.fill(used,false);


        generatePermute(nums,0,list,used);

        return result;
    }

    @Test
    public void test(){
        int []arr = {1,2,3};
        List<List<Integer>> result = permute(arr);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers = result.get(i);
            integers.forEach(e->{
                System.out.println(e);
            });
        }
    }
}
