package cn.bos.dfs.lc1034;

import java.util.Arrays;

/**
 * @classname: Lc1034
 * @description: default
 * @author: pyethel
 * @create: 2021/12/7 09:43
 */
public class Lc1034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1, 1, 1}, {1, 1, 1}, {1,1,1}};
        int[][] ints = solution.colorBorder(grid, 1, 1, 2);
        System.out.println(Arrays.deepToString(ints));
    }
}

class Solution {
    private int[][] grid;
    private int[][] visited;
    private int rows;
    private int cols;
    private int srcColor;
    private int targetColor;
    private final int[] dirX = {0, 0, -1, 1};
    private final int[] dirY = {1, -1, 0, 0};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.srcColor = color;
        this.targetColor = grid[row][col];
        this.visited = new int[rows][cols];
        dfs(row, col);
        for(int i =0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = srcColor;
                }
            }
        }
        return grid;
    }

    public boolean checkEdge(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return true;
        }
        if (visited[x][y] == 1) {
            return true;
        }
        if (grid[x][y] != targetColor) {
            return true;
        }
        return false;
    }

    // 有边界或周围其他颜色就算结束
    public boolean endState(int x, int y) {
        if (x == 0 || x == rows - 1 || y == 0 || y == cols - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (grid[x + dirX[i]][y + dirY[i]] != targetColor && grid[x + dirX[i]][y + dirY[i]] != 0) {
                return true;
            }
        }
        return false;
    }

    public void dfs(int x, int y) {
        visited[x][y] = 1;
        if (endState(x, y)) {
            grid[x][y] = 0;
        }
        for (int i = 0; i < 4; i++) {
            if (!checkEdge(x + dirX[i], y + dirY[i])) {
                dfs(x + dirX[i], y + dirY[i]);
            }
        }
    }
}

