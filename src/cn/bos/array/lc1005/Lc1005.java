package cn.bos.array.lc1005;

import java.util.Arrays;

/**
 * @classname: Lc1005
 * @description: default
 * @author: pyethel
 * @create: 2021/12/3 13:58
 */
public class Lc1005 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{3, -1, 0, 2};
        int i = solution.largestSumAfterKNegations(ints, 3);
        System.out.println(i);
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                index = i;
                break;
            }
        }
        int sum = 0;
        if (index == 0) {
            if (k % 2 == 0) {
                for (int num : nums) {
                    sum += num;
                }
            } else {
                for (int num : nums) {
                    sum += num;
                }
                sum = sum - nums[0] - nums[0];
            }
            return sum;
        }
        if (k < index) {
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            }
        } else {
            int fu = Math.abs(nums[index - 1]);
            int zheng = Math.abs(nums[index]);
            int min = Math.min(fu, zheng);
            int count = k - index;
            for (int i = 0; i < nums.length; i++) {

                if (i < index) {
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (count % 2 == 1) {
                sum = sum - min * 2;
            }
        }
        return sum;
    }
}
