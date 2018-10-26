package pers.wmx.leetcode.test;

import org.junit.jupiter.api.Test;
import pers.wmx.leetcode.LeetCode_283_MoveZeroes;

/**
 * @author: wangmingxin1
 * @create: 2018-10-26 14:16
 **/
public class testLeetCode_283_MoveZeroes {

    private static LeetCode_283_MoveZeroes  leetCode_283_MoveZeroes = new LeetCode_283_MoveZeroes();

    @Test
    public void testMoveZeroes1(){
        int []arr ={0,1,0,3,12};
        leetCode_283_MoveZeroes.moveZeroes1(arr);

        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    @Test
    public void testMoveZeroes2(){
        int []arr ={0,1,0,3,12};
        leetCode_283_MoveZeroes.moveZeroes2(arr);

        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    @Test
    public void testMoveZeroes3(){
        int []arr ={0,1,0,3,12};
        leetCode_283_MoveZeroes.moveZeroes3(arr);

        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    @Test
    public void testMoveZeroes4(){
        int []arr ={0,1,0,3,12};
        leetCode_283_MoveZeroes.moveZeroes4(arr);

        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
