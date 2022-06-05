package com;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        MyRunnable mr = new MyRunnable();
        Thread t2 = new Thread(mr);
        t2.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**class Solution {
    public static int strStr(String haystack, String needle) {
        int flag = 0;
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                if((i+needle.length())>haystack.length()){
                    return -1;
                }
                else if(haystack.substring(i,i+needle.length()).equals(needle)){
                    return i;
                }
                else{
                    continue;
                }
            }
            else{
                continue;
            }
        }
        return -1;
    }
}
*/