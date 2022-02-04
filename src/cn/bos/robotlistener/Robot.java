package cn.bos.robotlistener;

/**
 * @classname: Robot
 * @description: default
 * @author: pyethel
 * @create: 2021/10/14 14:27
 */
public class Robot {
    private RobotListener listener;

    public void registerListener(RobotListener listener) {
        this.listener = listener;
    }

    public void working() {
        if (listener != null) {
            Even even = new Even(this);
            this.listener.working(even);
        }
        System.out.println("机器人开始工作...");
    }
    public void dancing(){
        if(listener != null){
            Even even = new Even(this);
            this.listener.dancing(even);
        }
        System.out.println("机器人开始跳舞...");
    }

    public void working1() {
        System.out.println("机器人开始工作111...");
    }

    public void dancing1(){
        System.out.println("机器人开始跳舞111...");
    }
}
