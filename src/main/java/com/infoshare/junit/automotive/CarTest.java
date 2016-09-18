package com.infoshare.junit.automotive;

public class CarTest {

    public void engine_should_be_running_after_ignition() throws Exception {
        Car sut = new CarFactory().forBrand(Brand.HONDA).build();
        sut.ignite();
        if (!sut.isRunning()) {
            throw new RuntimeException("Error! Car is not running after ignition");
        };
        System.out.println("Car is running after ignition");
    }

    public void emmission_level_should_be_normal() throws Exception {
        Car sut = new CarFactory().forBrand(Brand.VW).build();
        sut.ignite();
//        sut.setLabMode(true);
        if (sut.measurePollution()!=EmissionLevel.NORMAL) {
            throw new RuntimeException("Error! Emmission level is not normal");
        };
        System.out.println("Emmission level is normal");
    }
}