package cn.bos.array.lc2022;

import java.util.Arrays;

/**
 * @classname: Solution
 * @description: default
 * @author: pyethel
 * @create: 2022/1/1 22:13
 */
public class Lc2022 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1, 1, 1, 1};
        int[][] ints1 = solution.construct2DArray(ints, 4, 1);
        System.out.println(Arrays.deepToString(ints1));
    }
}

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int size = original.length;
        int[][] result = new int[m][n];
        if (m * n != size) {
            return new int[][]{};
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }
        return result;
    }
}