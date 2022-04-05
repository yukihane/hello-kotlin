package com.github.yukihane.examples;

public class Main {
    public static void main(final String[] args) {
        final MySingleton instance = MySingleton.INSTANCE;
        System.out.println(instance);
    }
}
