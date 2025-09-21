package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Homework1 {

    //Вариант 1 - Работа с массивом

    public static void main(String[] args) {
        //Ввод данных
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите минимальную границу генерации чисел в массиве: ");
        int minPoint = scanner.nextInt();

        if (minPoint < 0) {
            System.out.println("Минимальное значение не должно быть отрицательным");
        } else {
            System.out.println("Введите максимальную границу генерации чисел в массиве:");
            int maxPoint = scanner.nextInt();

            if (maxPoint < minPoint || maxPoint < 0) {
                System.out.println("Максимальная граница должна быть больше 0 и больше минимальной");

            } else {
                System.out.println("Введите длину массива: ");
                int arrayLength = scanner.nextInt();

                if (arrayLength <= 0) {
                    System.out.println("Длинна массива должна быть должно быть больше 0");
                } else {
                    scanner.close();

                    int[] array = new int[arrayLength];

                    //Задание 1. Массив из 5 рандомных чисел
                    for (int i = 0; i < array.length; i++) {
                        array[i] = (int) (Math.random() * maxPoint);
                    }
                    System.out.println("Полученный массив: " + Arrays.toString(array));


                    //Задание 2. Вывод максимального значения
                    int max = array[0];
                    for (int i = 1; i < array.length; i++) {
                        if (array[i] > max) {
                            max = array[i];
                        }
                    }
                    System.out.println("Максимальное значение в массиве: " + max);


                    //Задание 3. Вывод минимального значения
                    int min = array[0];
                    for (int i = 1; i < array.length; i++) {
                        if (array[i] < min) {
                            min = array[i];
                        }
                    }
                    System.out.println("Минимальное значение в массиве: " + min);


                    //Задание 4. Вывод среднего значения
                    int sum = 0;
                    for (int i = 0; i < array.length; i++) {
                        sum += array[i];
                    }
                    System.out.println("Сумма элементов в массиве " + sum);
                    double srednee = (double) sum / array.length;
                    System.out.println("Среднее значение: " + srednee);


                    //Задание 5. сортировка массива по возрастанию
                    Arrays.sort(array);
                    System.out.println("Сортировка по возрастанию: " + Arrays.toString(array));


                    //Задание 6. сортировка массива по убыванию
                    Arrays.sort(array);

                    for (int i = 0; i < array.length / 2; i++) {
                        int tekushii = array[i];
                        array[i] = array[array.length - 1 - i];
                        array[array.length - 1 - i] = tekushii;
                    }

                    System.out.println("Сортировка по убыванию: " + Arrays.toString(array));
                }
            }
        }
    }
}
