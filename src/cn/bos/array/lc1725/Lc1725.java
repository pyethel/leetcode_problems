package cn.bos.array.lc1725;

import java.util.HashMap;
import java.util.Map;

/**
 * @classname: Lc1725
 * @description: default
 * @author: pyethel
 * @create: 2022/2/4 11:16
 */
public class Lc1725 {

}

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            Integer key = Math.min(rectangle[0], rectangle[1]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        return map.get(map.keySet().stream().max(Integer::compareTo).orElse(0));
    }
}