package org.example.homework3;


public final class ElectricScooter extends Transport {
    private final double batteryCapacity;
    private final int maxRange;

    public ElectricScooter(String model, int year, Engine engine, double batteryCapacity, int maxRange) {
        super(model, year, engine);
        this.batteryCapacity = batteryCapacity;
        this.maxRange = maxRange;
    }

    @Override
    public void start() {
        System.out.printf("Электросамокат %s включен", model);
    }

    @Override
    public void stop() {
        brake();
        System.out.printf("Электросамокат %s выключен", model);
    }

    @Override
    public String getInfo() {
        return String.format("Электросамокат %s (%d г.)" +
                        "   Двигатель: %s" +
                        "   Батарея: %.1f А·ч, Запас хода: %d км",
                model, year, engine.getInfo(), batteryCapacity, maxRange);
    }

    public double getBatteryCapacity() { return batteryCapacity; }
    public int getMaxRange() { return maxRange; }
}