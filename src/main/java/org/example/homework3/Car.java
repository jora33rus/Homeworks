package org.example.homework3;

public final class Car extends Transport {
    private final int doors;
    private final String driveType;

    public Car(String model, int year, Engine engine, int doors, String driveType) {
        super(model, year, engine);
        this.doors = doors;
        this.driveType = driveType;
    }

    @Override
    public void start() {
        System.out.printf("Автомобиль %s завелся", model);
    }

    @Override
    public void stop() {
        brake();
        System.out.printf("Автомобиль %s заглушен", model);
    }

    @Override
    public String getInfo() {
        return String.format("Автомобиль %s (%d г.)" +
                        "   Двигатель: %s" +
                        "   Двери: %d, Привод: %s",
                model, year, engine.getInfo(), doors, driveType);
    }


}
