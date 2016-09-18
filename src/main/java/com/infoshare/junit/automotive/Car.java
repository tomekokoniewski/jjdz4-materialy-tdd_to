package com.infoshare.junit.automotive;

public class Car {

    private final Brand brand;
    private boolean isRunning;
    private boolean labMode;

    Car(Brand brand) {
        this.brand = brand;
    }

    public Brand getBrand() {
        return brand;
    }

    public void ignite() {
        this.isRunning = true;
    }

    public void stop() {
        this.isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public EmissionLevel getEmmissionLevel() {
        if (!isRunning) {
            return EmissionLevel.NONE;
        } else if (brand==Brand.VW && labMode==true) {
            return EmissionLevel.ILLEGAL;
        } else if (brand==Brand.FSO) {
            return EmissionLevel.HIGH;
        }
        return EmissionLevel.NORMAL;
    }

    public void setLabMode(boolean labMode) {
        this.labMode = labMode;
    }

}
