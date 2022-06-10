package com;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 1、多线程共享数据时，线程不安全。
 * 2、多线程共享数据必须使用同步
 * 使用同步代码块、使用同步方法、使用Lock
 * synchronired准则
 * 使代码简短、不要阻塞如InputStream.read()、持有锁时不要对其他对象调用同步方法（容易死锁）
 * */
public class ThreadDemo4 {
    public static void main(String[] args) {
        MyRunnable5 mr5 = new MyRunnable5();
        Thread t1 = new Thread(mr5);
        Thread t2 = new Thread(mr5);
        t1.start();
        t2.start();
    }
}

class MyRunnable5 implements Runnable {
    private int ticket = 5;
    private Object obj = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            method2();
//                synchronized (obj){
//                    ticket--;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("你购买的票剩余"+ticket+"张");
//                }


        }

    }

    //同步方法，同步的对象是当前对象this
    private synchronized void method() {
        if (ticket > 0) {
            ticket--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你购买的票剩余" + ticket + "张");
        }
    }
    //互斥锁
    ReentrantLock lock = new ReentrantLock();
    //Lock实现同步
    private void method2(){
        lock.lock();
        try {
            if (ticket > 0) {
                ticket--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("你购买的票剩余" + ticket + "张");
            }
        }finally {
            lock.unlock();
        }
    }
}