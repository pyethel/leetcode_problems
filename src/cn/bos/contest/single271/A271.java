package cn.bos.contest.single271;

/**
 * @classname: A271
 * @description: default
 * @author: pyethel
 * @create: 2021/12/15 09:11
 */
public class A271 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countPoints("G4");
        System.out.println(i);
    }
}

class Solution {
    public int countPoints(String rings) {
        int[][] bucket = new int[10][3];
        char[] chars = rings.toCharArray();
        int length = chars.length;
        for(int i = 0; i < length; i+=2){
            int index;
            if('R'==(chars[i])){
                index = 0;
            }
            else if('G'==(chars[i])){
                index = 1;
            }
            else{
                index = 2;
            }
            bucket[chars[i+1]-'0'][index] = 1;
        }
        int count = 0;
        for (int[] ints : bucket) {
            boolean flag = true;
            for (int anInt : ints) {
                if(anInt != 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}