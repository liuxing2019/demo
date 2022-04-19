package com;

import java.util.Arrays;
class ListNode{
    int val;
    static ListNode ln = new ListNode(1);
    public ListNode(){
        System.out.println("构造方法执行了");
    }
    private ListNode(int val){
        this.val = val;
        System.out.println("私有");
    }
}
interface IEat{
    public static final int NUM = 10;
    void eat();
}
public class Main {
    public static void main(String[] args) {
    }
}