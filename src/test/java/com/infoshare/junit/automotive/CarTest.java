package com.infoshare.junit.automotive;

import com.infoshare.junit.automotive.CarFactory;

public class CarTest {

    public void engine_should_be_running_after_ignition() throws Exception {
        Car sut = new CarFactory().setBrand(Brand.HONDA).build();
        sut.ignite();
        assert sut.isRunning() : "OMG! Car is not running after ignition";
    }

    public void emmission_level_should_be_normal() {
        Car sut = new CarFactory().setBrand(Brand.VW).build();
        sut.ignite();
        assert sut.getEmmissionLevel()==EmissionLevel.NORMAL : "Emmission level is not normal";
    }
}