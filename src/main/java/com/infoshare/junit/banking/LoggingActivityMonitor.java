package com.infoshare.junit.banking;

import java.util.Observable;

public class LoggingActivityMonitor implements AccountMonitor {

    @Override
    public void connect() {
        System.out.println("LoggingActivityMonitor connected");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        System.out.println("LoggingActivityMonitor closed");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o + " updated with " + arg);
    }
}
