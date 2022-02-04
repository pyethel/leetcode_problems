package cn.bos.lc495;


/**
 * @classname: lc495
 * @description: default
 * @author: pyethel
 * @create: 2021/11/10 09:35
 */
public class lc495 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.findPoisonedDuration(new int[]{1, 2}, 2);
        System.out.println(res);
    }
}

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int length = timeSeries.length;
        int time = 0;
        for (int i = 0; i < length - 1; i++) {
            if (timeSeries[i] + duration > timeSeries[i + 1]) {
                time += timeSeries[i + 1] - timeSeries[i];
            } else {
                time += duration;
            }
        }
        time += duration;
        return time;
    }
}