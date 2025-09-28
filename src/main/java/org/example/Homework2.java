package org.example;
import java.util.Scanner;


public class Homework2 {

    public static void main(String[] args) {
        vectorInfo();
        generateRandomVectors();
    }

    static class Vector {
        String name;
        private final int x, y, z;
        private final double length;

        public Vector(String name, int x, int y, int z) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.z = z;
            this.length = Math.sqrt(x * x + y * y + z * z);
        }

        public int getX() {return x;}
        public int getY() {return y;}
        public int getZ() {return z;}
        public double getLength() {return length;}
        public String getName() {return name;}

        @Override
        public String toString() {
            return String.format("'%s': (%d, %d, %d)", name, x, y, z);
        }
    }

    public static void vectorInfo() {
        Scanner scanner = new Scanner(System.in);

        Vector vector1 = null;
        Vector vector2 = null;


        for (int i = 0; i < 2; i++) {

            System.out.println("Введите название вектора: " + (i + 1) + " ");
            String name = scanner.nextLine();
            System.out.println("Название вектора = " + name);

            System.out.println("Введите значение координаты X вектора: ");
            int x = Validator.validator(scanner);
            scanner.nextLine();

            System.out.println("Введите значение координаты Y вектора : ");
            int y = Validator.validator(scanner);
            scanner.nextLine();

            System.out.println("Введите значение координаты Z вектора : ");
            int z = Validator.validator(scanner);
            scanner.nextLine();

            if (i == 0) {
                vector1 = new Vector(name, x, y, z);
            } else {
                vector2 = new Vector(name, x, y, z);
            }
        }


        System.out.println("Название вектора " + vector1.getName()
                + " координаты вектора: X=" + vector1.getX() + " Y=" + vector1.getY() + " Z=" + vector1.getZ());
        System.out.println("Длина вектора " + vector1.getName() + " = " + vector1.getLength());

        System.out.println("Название вектора " + vector2.getName()
                + " координаты вектора: X=" + vector2.getX() + " Y=" + vector2.getY() + " Z=" + vector2.getZ());
        System.out.println("Длина вектора " + vector2.getName() + " = " + vector2.getLength());


        double scalar = vectorScalar(vector1, vector2);
        System.out.println("Скалярное произведение вектором = " + scalar);

        Vector product = vectorProduct(vector1, vector2);
        System.out.println("Векторное произведение = " + product);

        double cosAngle = vectorCosAngle(vector1, vector2);
        double angle = vectorAngle(vector1, vector2);

        System.out.println("Косинус угла: " + String.format("%.4f", cosAngle));
        System.out.println("Угол между векторами: " + String.format("%.2f", angle) + "°");

        Vector sum = vectorSum(vector1, vector2);
        System.out.println("Сумма векторов: " + sum);

        Vector dif = vectorDifference(vector1, vector2);
        System.out.println("Разность векторов: " + dif);

    }


    public static double vectorScalar(Vector v1L, Vector v2L) {
        //Для векторов a = (ax, ay, az) и b = (bx, by, bz)
        // скалярное произведение вычисляют по формуле: a · b = ax · bx + ay · by + az · bz
        return v1L.getX() * v2L.getX() + v1L.getY() * v2L.getY() + v1L.getZ() * v2L.getZ();
    }

    public static Vector vectorProduct(Vector v1, Vector v2) {
        // Формула векторного произведения:
        // i*(y1*z2 - z1*y2) - j*(x1*z2 - z1*x2) + k*(x1*y2 - y1*x2)
        int newX = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        int newY = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();
        int newZ = v1.getX() * v2.getY() - v1.getY() * v2.getX();

        return new Vector(v1.getName() + "×" + v2.getName(), newX, newY, newZ);

    }


    public static double vectorCosAngle(Vector v1, Vector v2) {
        // формула cos(θ) = (a·b) / (|a| × |b|)

        double dotProduct = vectorScalar(v1, v2);
        double lengthProduct = v1.getLength() * v2.getLength();

        if (lengthProduct == 0) {
            return 0;
        }

        return dotProduct / lengthProduct;
    }

    public static double vectorAngle(Vector v1, Vector v2) {
        double cos = vectorCosAngle(v1, v2);
        cos = Math.max(-1, Math.min(1, cos));
        return Math.acos(cos) * 180 / Math.PI;
    }

    public static Vector vectorSum(Vector v1, Vector v2) {
        int newX = v1.getX() + v2.getX();
        int newY = v1.getY() + v2.getY();
        int newZ = v1.getZ() + v2.getZ();
        return new Vector(v1.getName() + "+" + v2.getName(), newX, newY, newZ);

    }

    public static Vector vectorDifference(Vector v1, Vector v2) {
        int newX = v1.getX() - v2.getX();
        int newY = v1.getY() - v2.getY();
        int newZ = v1.getZ() - v2.getZ();
        return new Vector(v1.getName() + "-" + v2.getName(), newX, newY, newZ);

    }

    public static void generateRandomVectors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int N = scanner.nextInt();
        if (N <=0) {
            System.out.println("N должно быть целым числом");} else {
        scanner.close(); }

        Vector[] vectors = new Vector[N];

        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * 201) - 100;
            int y = (int) (Math.random() * 201) - 100;
            int z = (int) (Math.random() * 201) - 100;

            vectors[i] = new Vector("Вектор №" + (i + 1), x, y, z);
        }

        System.out.println("Случайные векторы:");
        for (Vector vector : vectors) {
            System.out.println(vector);
        }
    }
}