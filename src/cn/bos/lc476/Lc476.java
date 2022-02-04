package cn.bos.lc476;

/**
 * @classname: lc476
 * @description: default
 * @author: pyethel
 * @create: 2021/10/18 10:32
 */
public class Lc476 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int complement = solution.findComplement(2147483647);
        System.out.println(complement);
        System.out.println(Math.pow(2,31));
    }
}

class Solution {
    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        int binLength = binaryString.length();
        int mask = (int)(Math.pow(2, binLength) - 1);
        return num ^ mask;
    }
}
