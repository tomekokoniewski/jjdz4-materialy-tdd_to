package com.infoshare.junit.automotive;

public class CarTesterApp {
    public static void main(String[] args) {
        CarTest test = new CarTest();
        try {
            test.engine_should_be_running_after_ignition();
            test.emmission_level_should_be_normal();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
