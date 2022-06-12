package com;

public class ProducterCustomerDemo {
    public static void main(String[] args) {

    }
}

class Food {
    private String name;
    private String desc;

    /*
     * 生产产品
     * */
    public void set(String name, String desc) {
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
    }

    /*
     * 消费产品*/
    public void get() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "->" + this.getDesc());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Food() {
    }
}

class Producter implements Runnable{
    private Food food;
    public Producter(Food food){
        this.food = food;
    }
    @Override
    public void run() {

    }
}