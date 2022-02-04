package cn.bos.robotlistener;

/**
 * @classname: TestListener
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 15:40
 */
public class TestListener {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.registerListener(new MyRobotListener());
        robot.working();
        robot.dancing();
    }
}
