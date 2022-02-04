package cn.bos.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @classname: CollectorTest
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 09:58
 */
public class CollectorTest {
    public static void main(String[] args) {
        List<Character> chars = new ArrayList<>();
        chars.add('a');
        chars.add('a');
        chars.add('a');
        chars.add('d');
        chars.add('d');
        chars.add('s');
        chars.add('s');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        chars.add('x');
        Set<Character> characters = chars.parallelStream().collect(new MyCollector<>());
        System.out.println(characters);
    }
}
