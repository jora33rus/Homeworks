package org.example.homework3.enums;

public enum EngineType {
    INTERNAL_COMBUSTION("Двигатель внутреннего сгорания"),
    ELECTRIC_MOTOR("Электродвигатель"),
    JET_ENGINE("Реактивный двигатель"),
    NONE("Без двигателя");

    private final String description;

    EngineType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}