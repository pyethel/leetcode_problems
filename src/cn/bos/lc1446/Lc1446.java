package cn.bos.lc1446;

/**
 * @classname: Lc1446
 * @description: default
 * @author: pyethel
 * @create: 2021/12/1 09:39
 */
public class Lc1446 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxPower("abbcccddddeeeeedcba");
        System.out.println(i);
    }
}

class Solution {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int row = 1;
        int max = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                row++;
            } else {
                max = Math.max(row, max);
                row = 1;
            }
        }
        return max = Math.max(row, max);
    }
}
