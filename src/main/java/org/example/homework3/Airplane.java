package org.example.homework3;

public final class Airplane extends Transport {
    private final double wingspan;
    private final double maxAltitude;

    public Airplane(String model, int year, Engine engine, double wingspan, double maxAltitude) {
        super(model, year, engine);
        this.wingspan = wingspan;
        this.maxAltitude = maxAltitude;
    }

    @Override
    public void start() {
        System.out.printf("Самолет %s запустил двигатели", model);
    }

    @Override
    public void stop() {
        brake();
        System.out.printf("Самолет %s завершил полет", model);
    }

    @Override
    public String getInfo() {
        return String.format("Самолет %s (%d г.)" +
                        "   Двигатель: %s" +
                        "   Размах крыльев: %.1f м, Макс. высота: %.0f м",
                model, year, engine.getInfo(), wingspan, maxAltitude);
    }
}