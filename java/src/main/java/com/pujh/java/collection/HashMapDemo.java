package com.pujh.java.collection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Zhang", "张三");
        map.put("Li", "李四");
        // 循环写法
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
        for (String value : map.values()) {
            System.out.println(value);
        }
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        getCapacitySize(map);
    }

    // 反射获取HashMap容量
    private static void getCapacitySize(HashMap<String, String> map) {
        Class<?> clazz = map.getClass();
        Method method = null;
        Field size = null;
        try {
            method = clazz.getDeclaredMethod("capacity");
            method.setAccessible(true);
            System.out.println("capacity : " + method.invoke(map));
            size = clazz.getDeclaredField("size");
            size.setAccessible(true);
            System.out.println("size : " + size.get(map));
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
