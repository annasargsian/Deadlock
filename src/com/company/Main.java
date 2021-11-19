package com.company;

public class Main {

    public static final Object firstLock = new Object();
    public static final Object secondLock = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
                synchronized (secondLock) {
                    synchronized (firstLock) {
                        System.out.println("In block 1");
                    }
                }
        };

        Runnable runnable1 = () -> {
                synchronized (firstLock) {
                    synchronized (secondLock) {
                        System.out.println("In block 2");
                    }
                }
        };


        new Thread(runnable).start();
        new Thread(runnable1).start();
    }
}

