package cn.bos.chapter2.article6;

/**
 * @classname: Page22
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 13:59
 */
public class Page22 {
    private static long sum() {
        Long sum = 0L;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return sum;
    }
    private static long sum2() {
        long sum = 0L;
        long startTime = System.currentTimeMillis();
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return sum;
    }
    public static void main(String[] args) {
        long sum = Page22.sum();
        long l = Page22.sum2();
        System.out.println(sum);
        System.out.println(l);

    }
}
