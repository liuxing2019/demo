package com;

public class ProducterCustomerDemo {
    public static void main(String[] args) {

    }
}

class Food{
    private String name;
    private String desc;

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