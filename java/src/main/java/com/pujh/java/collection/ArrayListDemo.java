package com.pujh.java.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.set(0,0);
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 10));
        }
        System.out.println(list);
        System.out.println(getArrayListCapacity(list));
        list.add(12);
        System.out.println(getArrayListCapacity(list));
        list.remove(1);
        System.out.println(getArrayListCapacity(list));
    }

    public static int getArrayListCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
