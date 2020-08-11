package com.pujh.java.collection;

import java.util.LinkedList;

/**
 * modCount属性
 * modCount用于记录对象的修改次数
 * ，也基本存在于非线程安全的集合类中。注释大致的意思就是modCount用于迭代器中，
 * 当多线程环境下，若有个线程在遍历集合的过程中，被另一个线程修改了该集合，就会抛出异常。
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 100));
        }
        new Thread(() -> {
            for (int i:list) {
                try {
                    System.out.println(list.get(i));
                    if(50 == i) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("添加元素");
            list.add(20,20);
        }).start();
    }
}
