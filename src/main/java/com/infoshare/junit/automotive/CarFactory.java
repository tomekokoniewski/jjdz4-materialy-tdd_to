package com.infoshare.junit.automotive;

public class CarFactory {
    private Brand brand;

    public CarFactory setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Car build() {
        return new Car(brand);
    }
}