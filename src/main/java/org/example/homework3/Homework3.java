package org.example.homework3;

import org.example.homework3.enums.EngineType;
import org.example.homework3.enums.FuelType;
import org.example.homework3.enums.TransportType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Homework3 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Transport> transports = new HashMap<>();
    private static Transport selectedTransport;


    public static void main(String[] args) {
        getInfo();
        runApplication();
    }

    static void runApplication() {
        System.out.println("Java - управляй мечтой!");
        selectTransportType();
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> getTransportInfo();
                case "2" -> startManagement();
                case "3" -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }


    static void selectTransportType() {
        System.out.println("Введите название транспорта из предложенных текстом:");
        int n = 1;
        for (TransportType type : TransportType.values()) {
            System.out.println(n++ + "- " + type.getDescription());
        }

        System.out.print("Поле для ввода: ");
        String input = scanner.nextLine().trim();
        TransportType transportType = TransportType.displayTransportName(input);

        if (transportType == null) {
            System.out.println("Ошибка: неизвестный тип транспорта '" + input + "'");
            selectTransportType();
        } else {
            selectedTransport = transports.get(input.toLowerCase());
            System.out.println("Ваш выбор: " + transportType.getDescription());
        }
    }


    private static void printMenu() {
        System.out.println("1. Получить информацию по выбранному транспорту");
        System.out.println("2. Начать управление");
        System.out.println("3. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void getInfo() {
         transports.put("машина", new Car("Ваз2107", 2022,
                new Engine(EngineType.INTERNAL_COMBUSTION, 220, FuelType.PETROL),
                4, "задний"));

        transports.put("самолет", new Airplane("Бобролет", 2025,
                new Engine(EngineType.JET_ENGINE, 900, FuelType.KEROSENE),
                35.8, 12500));

        transports.put("велосипед", new org.example.homework3.Bicycle("Аист", 2023,
                21, "деревенский"));

        transports.put("самокат", new ElectricScooter("Безумное моноколесо", 2023,
                new Engine(EngineType.ELECTRIC_MOTOR, 25, FuelType.ELECTRIC),
                12.8, 30));
    }


    private static void getTransportInfo() {
        if (selectedTransport == null) {
            System.out.println("Транспорт не выбран!");
            return;
        }
        System.out.println("Информация о транспорте");
        System.out.println(selectedTransport.getInfo());
    }

    private static void startManagement() {
        if (selectedTransport == null) {
            System.out.println("Транспорт не выбран!");
            return;
        }
        manageTransport(selectedTransport);
    }

    private static void manageTransport(Transport transport) {
        while (true) {
            System.out.println("Управление: " + transport.getModel());
            System.out.println(transport.getInfo());
            System.out.printf("Текущая скорость: %.1f км/ч, Максимальная скорость: %.0f км/ч",
                    transport.getCurrentSpeed(), transport.getSpeed());
            System.out.println("1. Завести");
            System.out.println("2. Ехать");
            System.out.println("3. Остановиться");
            System.out.println("4. Заглушить");
            System.out.println("5. Назад в меню");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> transport.start();
                case "2" -> {
                    System.out.print("Введите скорость (км/ч): ");
                    try {
                        double speed = Double.parseDouble(scanner.nextLine());
                        transport.accelerate(speed);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите корректное значение скорости");
                    }
                }
                case "3" -> transport.brake();
                case "4" -> transport.stop();
                case "5" -> { return; }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}