package org.example.homework3;


public abstract sealed class Transport
        permits ElectricScooter, Airplane, Bicycle, Car {

    protected final String model;
    protected final int year;
    protected final Engine engine;
    protected double currentSpeed;

    public Transport(String model, int year, Engine engine) {
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.currentSpeed = 0;
    }

    public abstract void start();
    public abstract void stop();
    public abstract String getInfo();

    public void accelerate(double speed) {
        double maxSpeed = engine.getSpeed();
        this.currentSpeed = Math.min(speed, maxSpeed);
        System.out.printf("%s разгоняется до %.1f км/ч\n", model, currentSpeed);
    }

    public void brake() {
        this.currentSpeed = 0;
        System.out.printf("%s остановился\n", model);
    }

    public double getSpeed() {
        return engine.getSpeed();
    }

    // Геттеры
    public String getModel() { return model; }
    public double getCurrentSpeed() { return currentSpeed; }
}