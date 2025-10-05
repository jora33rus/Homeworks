package org.example.homework3.enums;

    public enum FuelType {
        PETROL("Бензин"),
        ELECTRIC("Электричество"),
        KEROSENE("Авиационный керосин"),
        FOOD("Еда");

        private final String description;

        FuelType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }


