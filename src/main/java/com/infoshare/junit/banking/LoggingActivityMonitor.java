package com.infoshare.junit.banking;

import java.util.Observable;
import com.google.common.base.Stopwatch;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class LoggingActivityMonitor implements AccountMonitor {

    @Override
    public void connect() {
        Stopwatch watch = Stopwatch.createStarted();
        System.out.println("LoggingActivityMonitor created");
        try {
            Thread.sleep(1000);
            System.out.println("LoggingActivityMonitor connected after " + watch.elapsed(TimeUnit.MILLISECONDS)+"ms");
            watch.stop();
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
