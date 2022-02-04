package cn.bos.offerII069;

/**
 * @classname: offerII069
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 10:50
 */
public class offerII069 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int i = solution.peakIndexInMountainArray(arr);
        System.out.println(i);
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left < right) {
            int flag = isPeak(left, right, arr);
            if (flag == 0) {
                return (left + right) / 2;
            }
            if (flag == -1) {
                left = (left + right) / 2;
            }
            if (flag == 1) {
                right = (left + right) / 2;
            }
        }
        return 0;
    }

    private int isPeak(int l, int r, int[] arr) {
        int mid = (l + r) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return 0;
        }
        if (arr[mid] > arr[mid - 1]) {
            return -1;
        }
        if (arr[mid] > arr[mid + 1]) {
            return 1;
        }
        return 0;
    }
}
