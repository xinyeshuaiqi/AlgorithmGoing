package pers.wmx.leetcode;

import java.util.Arrays;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-08 10:26
 **/
public class LeetCode_79_WordSearch {

    int m = 0;
    int n = 0;

    boolean [][]visited = null;

    //用一个二维数组模拟一个点向四个方向移动
    int [][]direction = {
            {-1,0},  //向上走
            {0,1},   //向右走
            {1,0},   //向下走
            {0,-1},  //向左走
    };

    //在移动的过程中，要保证在给定的区域(不能越界)
    boolean inArea(int row,int col){
        if(row>=0 && row<m && col>=0 && col<n){
            return true;
        }
        return false;
    }

    boolean searchWord(char[][] board, String word, int row, int col, int index){

        if(index == word.length()-1){    //检查的是word中最后一个元素
            return board[row][col] == word.charAt(index);
        }

        if(board[row][col] == word.charAt(index)){
            visited[row][col] = true;

            //从 (row,col)开始向四个方向寻找
            for (int k = 0; k <direction.length ; k++) {
                int nextRow = row + direction[k][0];
                int nextCol = col + direction[k][1];

                //下一个点在有效区域内而且下一个点没有访问过
                if(inArea(nextRow,nextCol) && !visited[nextRow][nextCol]){
                    boolean flag = searchWord(board, word, nextRow, nextCol, index + 1);
                    if(flag){
                        return true;
                    }
                }
            }

            visited[row][col] = false;   //回溯
        }

        return false;

    }

    public boolean exist(char[][] board, String word) {

        m= board.length;  //行
        n =board[0].length;  //列

        visited = new boolean[m][n];

        for (int i = 0; i <m ; i++) {
            Arrays.fill(visited[i],false);
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(searchWord(board,word,i,j,0)){    //从当前点(i,j)出发
                    return true;
                }
            }
        }

        return false;
    }
}
