package ru.annin.penzgtulesson02;

import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Даны 5 чисел типа int. Вывести их в порядке возрастания, используя цикл.
 *
 * @author Pavel Annin
 */
public class Main {

    private static final int SIZE_NUMBER = 5;

    public static void main(String[] args) {
        final List<Integer> numbers = enterNumbers(SIZE_NUMBER);
        System.out.println("Исходный массив: " + numbers.toString());

        for (int i = 0; i < numbers.size(); ++i) {
            for (int j = numbers.size() - 1; j > i; --j) {
                if (numbers.get(i).compareTo(numbers.get(j)) > 0) {
                    Collections.swap(numbers, i, j);
                }

            }
        }

        System.out.println("Отсортированный массив: " + numbers.toString());
    }

    @NotNull
    private static List<Integer> enterNumbers(int size) {
        final Random random = new Random();
        return Stream.generate(() -> random.nextInt(32))
                .limit(size)
                .collect(Collectors.toList());
    }
}