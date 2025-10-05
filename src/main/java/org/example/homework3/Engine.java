package org.example.homework3;


import org.example.homework3.enums.EngineType;
import org.example.homework3.enums.FuelType;

public class Engine {
    private final EngineType type;
    private final double speed;
    private final FuelType fuelType;

    public Engine(EngineType type, double maxSpeed, FuelType fuelType) {
        this.type = type;
        this.speed = maxSpeed;
        this.fuelType = fuelType;
    }

    public EngineType getType() { return type; }
    public double getSpeed() { return speed; }
    public FuelType getFuelType() { return fuelType; }

    public String getInfo() {
        return String.format("%s, макс. скорость: %.0f км/ч, топливо: %s",
                type.getDescription(), speed, fuelType.getDescription());
    }
}


