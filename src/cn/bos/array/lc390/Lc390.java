package cn.bos.array.lc390;

/**
 * @classname: Lc390
 * @description: default
 * @author: pyethel
 * @create: 2022/1/2 09:26
 */
public class Lc390 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lastRemaining(9);
    }
}

class Solution {
    public int lastRemaining(int n) {
        int[] arr = new int[n+1];
        for(int i = 1; i<= n; i++){
            arr[i] = i;
        }
        int count = n;
        while (count/2 >=1){
            for(int i = 1; i<= count/2; i++){
                arr[i] = arr[2*i];
            }
            count/=2;
            if(count%2 == 0){
                for(int i = 1; i<= (count/2); i++){
                    arr[i] = arr[2*i-1];
                }
            }else{
                for(int i = 1; i<= count/2; i++){
                    arr[i] = arr[2*i];
                }
            }
            count/=2;
        }
        return arr[1];
    }
}