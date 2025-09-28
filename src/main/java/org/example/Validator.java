package org.example;

import java.util.Scanner;

public class Validator {


    public static Integer validator (Scanner scanner) {

        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    }
