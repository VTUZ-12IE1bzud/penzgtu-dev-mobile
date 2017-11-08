package ru.annin.penzgtulesson02;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ввести строку, символ. При помощи цикла найти в строке заданный символ и вывести его номер в строке.
 *
 * @author Pavel Annin.
 */
public class Main {

    public static void main(String[] args) {
        final String string = enterString();
        final char wanted = enterChar();

        final List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) == wanted) {
                indexs.add(i + 1);
            }
        }

        if (indexs.isEmpty()) {
            System.out.println("Искомового символа в строке не найдено :(");
        } else {
            System.out.println("Искомый символ находится на следующих позициях: " + indexs.toString());
        }
    }

    @NotNull
    private static String enterString() {
        System.out.println("Введите строку:");
        final Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    @NotNull
    private static char enterChar() {
        System.out.println("Введите искомый символ:");
        final Scanner in = new Scanner(System.in);
        return in.next().charAt(0);
    }
}