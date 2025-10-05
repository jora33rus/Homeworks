package org.example.homework3.enums;

        public enum TransportType {
            Car("Машина"),
            Plain("Самолет"),
            ElectroCar("Самокат"),
            Bicycle("Велосипед");

            private  final String description;

            TransportType(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }

            public static TransportType displayTransportName(String input) {
                for (TransportType type : TransportType.values()) {
                    if (type.getDescription().equalsIgnoreCase(input)) {
                        return type;
                    }
                }
                return null;
            }
        }


