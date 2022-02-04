package cn.bos.inte;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: IntegerTest
 * @description: TODO 类描述
 * @author: pyethel
 * @create: 2021/9/5 13:02
 */
public class IntegerTest {
    public static void main(String[] args) {
        IntegerTest integerTest = new IntegerTest();
        integerTest.fun2();
    }

    public void fun2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (Integer integer : list) {
            list.remove(integer);
        }
    }

    public void fun1() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(5);
        Object o = integerArrayList.clone();
        if (o instanceof ArrayList) {
            ArrayList<Integer> clone = (ArrayList<Integer>) o;
            clone.remove(1);
        }
        integerArrayList.remove(new Integer(1));

        System.out.println(integerArrayList);
    }
}
