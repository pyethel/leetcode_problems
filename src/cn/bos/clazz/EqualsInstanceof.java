package cn.bos.clazz;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @classname: EqualsInstanceof
 * @description: TODO 类描述
 * @author: pyethel
 * @create: 2021/9/3 14:23
 */
public class EqualsInstanceof {
    public static void main(String[] args) throws ClassNotFoundException {
        EqualsInstanceof equalsInstanceof = new EqualsInstanceof();
        EI ei = new EI();
        EII eii = new EII();
        System.out.println(ei.getClass());
        System.out.println(eii.getClass());
        System.out.println(equalsInstanceof.getClass());
        EIInstance eiInstance = new EIInstance(){

        };
        EIInstance e2 = new EIInstance(){

        };
        System.out.println(eiInstance.getClass());
        System.out.println(e2.getClass());
        System.out.println(EIInstance.class);
        System.out.println(Class.forName("cn.bos.clazz.EIInstance"));
        System.out.println();
        System.out.println(equalsInstanceof instanceof EqualsInstanceof);
    }
}
class EI extends EqualsInstanceof{
}
interface EIInstance{
}
class EII implements EIInstance{
}