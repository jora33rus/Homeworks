package org.example.homework3;


import org.example.homework3.enums.EngineType;
import org.example.homework3.enums.FuelType;

public final class Bicycle extends Transport {
    private final int gears;
    private final String bicycleType;

    public Bicycle(String model, int year, int gears, String bicycleType) {
        super(model, year, new Engine(EngineType.NONE, 40, FuelType.FOOD));
        this.gears = gears;
        this.bicycleType = bicycleType;
    }

    @Override
    public void start() {
        System.out.printf("Велосипед %s готов к поездке\n", model);
    }

    @Override
    public void stop() {
        brake();
        System.out.printf("Велосипед %s остановлен\n", model);
    }

    @Override
    public String getInfo() {
        return String.format("Велосипед %s (%d г.)\n" +
                        "   Тип: %s, Передачи: %d\n" +
                        "   Двигатель: %s",
                model, year, bicycleType, gears, engine.getInfo());
    }
}