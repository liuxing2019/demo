package com;

public class ThreadDemo3 {
    public static void main(String[] args) {
        MyRunnable4 mr4 = new MyRunnable4();
        Thread t = new Thread(mr4);
        //线程分为守护线程和用户线程，当进程中没有用户线程时，JVM会退出。
        t.setDaemon(true);//把线程设置为守护线程
        t.setName("Thread-t");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("main-"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("--"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
