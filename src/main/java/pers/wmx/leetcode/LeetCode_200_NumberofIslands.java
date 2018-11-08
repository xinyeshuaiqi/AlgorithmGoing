package pers.wmx.leetcode;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 *
 *
 * @author: wangmingxin1
 * @create: 2018-11-08 11:30
 **/
public class LeetCode_200_NumberofIslands {

    int m;
    int n;

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

    private void exploreIsland(char[][] grid, int row, int col) {

        for (int i = 0; i <direction.length ; i++) {
            int nextRow= row + direction[i][0];
            int nextCol= col + direction[i][1];

            if(inArea(nextRow,nextCol) && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1'){
                visited[nextRow][nextCol] = true;
                exploreIsland(grid,nextRow,nextCol);
            }

        }
    }

    public int numIslands(char[][] grid) {
        m=grid.length;

        if(m==0){
            return 0;
        }

        n=grid[0].length;

        int result = 0;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    result++;
                    visited[i][j]=true;
                    //知道了这里有个岛屿，那么通过深度优先遍历来探索一下这个岛屿有多大(做标记)
                    exploreIsland(grid,i,j);  //针对这个点（i,j）做深度优先遍历
                }
            }
        }

        return result;
    }


}
