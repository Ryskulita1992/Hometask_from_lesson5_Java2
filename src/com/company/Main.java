package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem=new Semaphore(4, true);
        CountDownLatch cdl=new CountDownLatch(100);

        for (int i = 1; i<=100; i++) {
            new Passengers(sem, i,cdl).start();

        }
        try {
            cdl.await();
            System.out.println("All passengers arrived and bus is going");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
	// write your code here
    }

