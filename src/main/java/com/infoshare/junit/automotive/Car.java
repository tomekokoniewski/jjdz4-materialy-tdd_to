package com.infoshare.junit.automotive;

public class Car {

    private final Brand brand;
    private boolean isRunning;
    private EmissionLevel emmissionLevel;

    Car(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void ignite() {
        this.isRunning = true;
        this.emmissionLevel = brand==Brand.VW? EmissionLevel.ILLEGAL : EmissionLevel.NORMAL;
    }

    public void stop() {
        this.isRunning = false;
        this.emmissionLevel = EmissionLevel.NONE;
    }

    public boolean isRunning() {
        return isRunning;
    }


    public EmissionLevel getEmmissionLevel() {
        return emmissionLevel;
    }
}
