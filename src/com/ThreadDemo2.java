package com;
/*
*中断线程：
* 1、使用interrupt,设置一个中断标记
* 2、自定义标记方式（推荐使用）
* */
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable2 mr2 = new MyRunnable2();
        Thread t = new Thread(mr2);
        //t.start();

        MyRunnable3 mr3 = new MyRunnable3();
        Thread t2 = new Thread(mr3);
        t2.start();

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==20){
                mr3.flag = false;
//                t.interrupt();//中断线程，只是做了中断标记
//                try {
//                    t.join();//让t线程执行完毕
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

    }
}

class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(Thread.interrupted()){//测试中断状态，会把中断状态清除
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //InterruptedException:当抛出此异常时，该线程的中断状态将被清除。
                Thread.currentThread().interrupt();
            }
        }

    }
}

class MyRunnable3 implements Runnable{
    public boolean flag = true;
    public MyRunnable3(){
        flag = true;
    }

    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println(Thread.currentThread().getName()+"=="+(i++));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}