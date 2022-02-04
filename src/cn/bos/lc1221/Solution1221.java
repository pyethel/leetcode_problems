package cn.bos.lc1221;

/**
 * @classname: Solution1221
 * @description: TODO 类描述
 * @author: pyethel
 * @create: 2021/9/7 21:57
 */
public class Solution1221 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.balancedStringSplit("RLRRLLRLRL");
        System.out.println(i);
    }
}

class Solution {
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int count = 0;
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'R') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }
}
