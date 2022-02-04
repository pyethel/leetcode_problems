package cn.bos.lc2105;

/**
 * @classname: Lc2105
 * @description: default
 * @author: pyethel
 * @create: 2021/12/15 09:31
 */
public class Lc2105 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumRefill(new int[]{5}, 10, 8);
        System.out.println(i);
    }
}

class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int remainA = capacityA;
        int remainB = capacityB;
        int indexA = 0;
        int indexB = plants.length - 1;
        int count = 0;
        while (indexA < indexB) {
            if (remainA < plants[indexA]) {
                count++;
                remainA = capacityA;
            }
            if (remainB < plants[indexB]) {
                count++;
                remainB = capacityB;
            }
            remainA = remainA - plants[indexA];
            remainB = remainB - plants[indexB];
            indexA++;
            indexB--;
        }
        if (indexA == indexB) {
            if (remainA < plants[indexA] && remainB < plants[indexB]) {
                count++;
            }
        }
        return count;
    }
}