package com.infoshare.junit.$1_first_test;

import com.infoshare.junit.automotive.Brand;
import com.infoshare.junit.automotive.Car;
import com.infoshare.junit.automotive.CarFactory;
import com.infoshare.junit.automotive.EmissionLevel;
import org.junit.Assert;
import org.junit.Test;

public class CarJunitTest {

    @Test
    public void engine_should_be_running_after_ignition() throws Exception {
        Car sut = new CarFactory().setBrand(Brand.FSO).build();
        sut.ignite();
        Assert.assertTrue("OMG! Car is not running after ignition", sut.isRunning());
    }

    @Test
    public void emmission_level_should_be_normal() {
        Car sut = new CarFactory().setBrand(Brand.HONDA).build();
        sut.ignite();
        Assert.assertTrue(sut.getEmmissionLevel()== EmissionLevel.NORMAL);
    }

    @Test
    public void vw_emmision_level_should_be_high() {
        Car sut = new CarFactory().setBrand(Brand.VW).build();
        sut.ignite();
        sut.setLabMode(true);
        Assert.assertTrue(sut.getEmmissionLevel()==EmissionLevel.NORMAL);
    }
}
