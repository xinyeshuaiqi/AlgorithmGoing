package pers.wmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-08 11:52
 **/
public class LeetCode_51_NQueens {

    List<List<String>> result = new ArrayList<>();

    //表示列和对角线的位置是否已被占用，如果被占用了，就置位true
    boolean []col;
    boolean []diagonal1;  //对角线1
    boolean []diagonal2;  //对角线2


    public List<List<String>> solveNQueens(int n) {

        col=new boolean[n];
        diagonal1 = new boolean[2*n-1];
        diagonal2 = new boolean[2*n-1];

        //先要一个列表保存每行的皇后在第几列
        List <Integer>  location = new ArrayList<>();
        putQueen(n,0,location);

        return result;
    }

    //摆放第index行皇后的位置
    private void putQueen(int n, int index, List<Integer> location) {
        if(index == n){
            result.add(generateBoard(n,new ArrayList<Integer>(location)));
            return;
        }

        for (int i = 0; i < n ; i++) {
            //尝试摆放到第index行,第i列
            if(!col[i]  && !diagonal1[index+i] && !diagonal2[index-i+n-1]){
                //说明满足摆放在(index,i)的条件

                //于是这个位置被占用，这个列，和处于同一对角线的位置都置位true
                col[i]=true;
                diagonal1[index+i]=true;
                diagonal2[index-i+n-1]=true;
                //System.out.println(i);
                location.add(i);

                //这一行摆放好了，摆放下一行
                putQueen(n,index+1,location);

                //回溯
                col[i]=false;
                diagonal1[index+i]=false;
                diagonal2[index-i+n-1]=false;
                location.remove(location.size()-1);
            }
        }

    }

    private List<String> generateBoard(int n, ArrayList<Integer> location) {

        List<String>  board = new ArrayList<>();

        String str = "";
        for (int i = 0; i < n; i++) {
            str+=".";
        }
        
        for (int i = 0; i <n ; i++) {
            board.add(str);
        }

        for (int i = 0; i <location.size() ; i++) {
            Integer col = location.get(i);   //第i行的皇后在第几列
            char[] temp = board.get(i).toCharArray();
            temp[col]='Q';
            board.set(i,new String(temp));
        }

        return board;
    }

    @Test
    public void test(){
        List<List<String>> result = solveNQueens(4);
        
        System.out.println(result.size());
        
        for (int i = 0; i <result.size() ; i++) {
            for (int j = 0; j <result.get(i).size() ; j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
