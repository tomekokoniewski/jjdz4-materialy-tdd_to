package com.infoshare.junit.automotive;

public class CarTesterApp {

    public static void main(String[] args) throws Exception {
        CarTest test = new CarTest();
        test.emmission_level_should_be_normal();
        test.engine_should_be_running_after_ignition();

        System.out.println("-                      -");
        System.out.println("Car is ready for a drive");
        System.out.println("-                      -");
    }
}
