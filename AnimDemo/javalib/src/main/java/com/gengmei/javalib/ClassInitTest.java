package com.gengmei.javalib;

public class ClassInitTest {
    private static int num = 1;
    private static int num1 = 10;
    static {
        num = 2;
        num1 = 20;
        System.out.println(num);
        System.out.println(num1);
    }


    public static void main(String[] args) {
        System.out.println(num);
        System.out.println(num1);
    }
}
