package com.company;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers  extends Thread{
    Semaphore ps;
    int id;
    private CountDownLatch cdl;

    public Passengers(Semaphore ps, int id, CountDownLatch cdl) {
        this.ps = ps;
        this.id = id;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        pays();
        super.run();
    }

    public synchronized void pays() {
            try {
                ps.acquire();
                System.out.println("Passenger " + id+ " comes to the cash counter");
                sleep(1000);

                System.out.println("Passenger " + id+ " pays for the ticket");
                sleep(1000);

                System.out.println("Passenger " + id+ " leaving the cash counter and goes to the bus ");
                ps.release();
                sleep(3000);
                cdl.countDown();
            } catch (InterruptedException e) {
                System.out.println(" interrupted");
            }
        }
    }

