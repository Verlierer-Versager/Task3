package ru.vsu.cs.util;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ArrayUtils {
    private static final Random RND = new Random();


    public static int[] toPrimitive(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // автоматическая распаковка из объекта
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] toIntArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        // из List<Integer> можно получить Integer[]
        Integer[] arr = list.toArray(new Integer[0]);
        // Integer[] -> int[]
        return ArrayUtils.toPrimitive(arr);
    }

    /**
     * Конвертация массива строк в двухмерный массив чисел int[][]
     */
    public static int[][] toIntArray2(String[] lines) {
        int[][] arr2 = new int[lines.length][];
        for (int r = 0; r < lines.length; r++) {
            arr2[r] = toIntArray(lines[r]);
        }
        return arr2;
    }


    /**
     * Чтение всего текстового файла в массив строк
     */
    public static String[] readLinesFromFile(String fileName) throws FileNotFoundException {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            lines = new ArrayList<>();
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
            // обязательно, чтобы закрыть открытый файл
        }
        return lines.toArray(new String[0]);
    }


    /**
     * Чтение двухмерного массива из текстового файла
     */
    public static int[][] readIntArray2FromFile(String fileName) {
        try {
            return toIntArray2(readLinesFromFile(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
