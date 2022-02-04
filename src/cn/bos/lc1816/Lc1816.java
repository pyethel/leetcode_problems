package cn.bos.lc1816;

/**
 * @classname: Lc1816
 * @description: default
 * @author: pyethel
 * @create: 2021/12/6 14:13
 */
public class Lc1816 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String hello_how_are_you_contestant = solution.truncateSentence("Hello how are you Contestant", 4);
        System.out.println(hello_how_are_you_contestant);
    }
}

class Solution {
    public String truncateSentence(String s, int k) {
        String[] split = s.split("\\b");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * k - 1; i++) {
            sb.append(split[i]);
        }
        return sb.toString();
    }
}
