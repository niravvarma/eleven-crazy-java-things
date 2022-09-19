package com.github.hannotify.elevencrazyjavathings.number6;

import java.util.Arrays;

public class Number6MethodOverloadingPriorities {

    public static void main(String[] args) {
        printSum(2, 7);
    }

    public static void printSum(Integer a, Integer b){
        System.out.format("In printSum(Integer): %d%n", a + b);
    }

    public static void printSum(double a, double b){
        System.out.format("In printSum(double): %f%n", a + b);
    }

    public static void printSum(int... ints){
        System.out.format("In printSum(int...): %d%n", Arrays.stream(ints).sum());
    }

    /**
     * Note: even though integers are passed to printSum method in main class
     * java calls the method first with primitive type i.e. double > Integer > int...
     *
     * if we had another method i.e. printSum(int a, int b), then order of call would be int > double > Integer > int..
     */

}
