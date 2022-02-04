package cn.bos.array.lc748;

/**
 * @classname: Lc748
 * @description: default
 * @author: pyethel
 * @create: 2021/12/10 09:02
 */
public class Lc748 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(s);
    }
}

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] buckets = new int[26];
        char[] chars = licensePlate.toLowerCase().toCharArray();
        for (char aChar : chars) {
            if (aChar - 'a' < 0) {
                continue;
            }
            if (aChar - 'a' > 25) {
                continue;
            }
            buckets[aChar - 'a']++;
        }
        int length = Integer.MAX_VALUE;
        String shortestWord = null;
        for (int i = 0; i < words.length; i++) {
            int[] bucketsClone = buckets.clone();
            char[] wcArr = words[i].toCharArray();
            for (char aChar : wcArr) {
                bucketsClone[aChar - 'a']--;
            }
            boolean flag = true;
            for (int i1 : bucketsClone) {
                if (i1 > 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if (length > words[i].length()) {
                    length = words[i].length();
                    shortestWord = words[i];
                }
            }
        }
        return shortestWord;
    }
}

