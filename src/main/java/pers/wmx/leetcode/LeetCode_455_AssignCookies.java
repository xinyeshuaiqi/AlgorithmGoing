package pers.wmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj.
 * If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 *
 *Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-09 14:36
 **/
public class LeetCode_455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length-1;
        int si = s.length-1;

        while(gi >= 0 && si >= 0){
            if(s[si]>=g[gi]){
                result++;
                gi--;
                si--;
            }else
                gi--;
        }

        return result;
    }

    @Test
    public void test(){
        int []g = {1,2,3};
        int []s = {1,1};

        int result = findContentChildren(g, s);
        System.out.println(result);
    }
}
