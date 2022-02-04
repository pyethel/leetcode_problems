package cn.bos.lc400;


/**
 * @classname: Lc400
 * @description: default
 * @author: pyethel
 * @create: 2021/11/30 09:33
 */
public class Lc400 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nthDigit = solution.findNthDigit(2147483647);
        System.out.println(nthDigit);
    }
}

class Solution {
    private final int[] arr = {0, 9, 189, 2889, 38889, 488889, 5888889, 68888889, 788888889, 2147483647};

    public int findNthDigit(int n) {
        int digit = 0;
        for (int i = 1; i <= 9; i++) {
            if (n <= arr[i]) {
                digit = i;
                break;
            }
        }
        int d = n - arr[digit - 1];
        // 第几个数字
        int shang = (int) Math.floor(d / digit);
        int yu = d % digit;
        int pow = (int) Math.pow(10, digit - 1);
        int ji = shang + pow;
        int aim;
        if (yu == 0) {
            aim = ji -1;
            String s = Integer.toString(aim);
            String substring = s.substring(s.length()-1);
            return Integer.parseInt(substring);
        }
        aim = ji;
        String s = Integer.toString(aim);
        String substring = s.substring(yu - 1, yu);
        return Integer.parseInt(substring);
    }
}
