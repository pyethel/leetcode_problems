package cn.bos.robotlistener;

/**
 * @classname: MyRobotListener
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 14:40
 */
public class MyRobotListener implements RobotListener {

    @Override
    public void working(Even even) {
        Robot robot = even.getRobot();
        robot.dancing1();
    }

    @Override
    public void dancing(Even even) {
        Robot robot = even.getRobot();
        robot.working1();
    }
}
