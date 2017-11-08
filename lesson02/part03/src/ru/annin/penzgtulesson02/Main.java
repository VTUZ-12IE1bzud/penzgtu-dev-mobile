package ru.annin.penzgtulesson02;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Упорядочить массив Х [a][b] по 1 индексу, используя метод Arrays.sort.
 * а - случайные числа от 1 до 10
 * b- марки авто
 *
 * @author Pavel Annin.
 */
public class Main {

    private static final int SIZE = 10;
    private static final String[] BRANDS = new String[]{"Audi", "BMW", "Ford", "Honda", "Lada",
            "Mazda", "Mercedes-Benz", "Suzuki", "Volkswagen", "Skoda", "Toyota"};

    public static void main(String[] args) {
        final List<Car> cars = enterCars(SIZE);
        System.out.println("Исходный данные: " + cars.toString());

        Collections.sort(cars);
        System.out.println("Отсортированные данные: " + cars.toString());
    }

    private static List<Car> enterCars(int size) {
        final Random random = new Random();
        return Stream.generate(() -> random.nextInt(BRANDS.length))
                .limit(size)
                .map((num) -> new Car(num, BRANDS[num]))
                .collect(Collectors.toList());
    }
}