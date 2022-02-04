package cn.bos.lc496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @classname: lc496
 * @description: default
 * @author: pyethel
 * @create: 2021/10/26 22:16
 */
public class Lc496 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] ints = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int l1 = nums1.length;
        int l2 = nums2.length;
        for (int i = 0; i < l2; i++) {
            for (int j = i; j < l2; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
                if (j == l2 - 1) {
                    map.put(nums2[i], -1);
                }
            }
        }
        int[] res = new int[l1];
        for (int i = 0; i < l1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
