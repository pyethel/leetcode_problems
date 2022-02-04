package cn.bos.lc165;

/**
 * @classname: Solution
 * @description: TODO 类描述
 * @author: pyethel
 * @create: 2021/9/1 11:44
 */
public class Solution165 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("7.5.2.4", "7.5.3"));
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int max = Math.max(len1, len2);
        int[] val1 = new int[max];
        int[] val2 = new int[max];
        for (int i = 0; i < len1; i++) {
            val1[i] = Integer.parseInt(v1[i]);
        }
        for (int i = 0; i < len2; i++) {
            val2[i] = Integer.parseInt(v2[i]);
        }
        for(int i = len1; i < max; i++){
            val1[i] = 0;
        }
        for(int i = len2; i < max; i++){
            val2[i] = 0;
        }
        for (int i = 0; i < max; i++) {
            if (val1[i] > val2[i]) {
                return 1;
            } else if (val1[i] < val2[i]) {
                return -1;
            }
        }
        return 0;

    }
}
