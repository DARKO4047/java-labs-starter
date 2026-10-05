package edu.course.lab01;

import java.util.Arrays;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }

    /**
     * Возвращает true, если число четное.
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }


    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть null");
        }
        text = text.toLowerCase();
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)){
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;

    }


    public static double average(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        if (values.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        return (double)Arrays.stream(values).sum()/values.length;
    }


    public static int Min(int[] list) {
        if (list == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        if (list.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        int i = 1;
        int min = list[0];
        while (i < list.length) {
            if (list[i] < min) {
                min = list[i];

            }
            i = i + 1;
        }
    return min;
    }

    public static int Max(int[] list) {
        if (list == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        if (list.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        int i = 1;
        int max = list[0];
        while (i < list.length) {
            if (list[i] > max) {
                max = list[i];

            }
            i = i + 1;
        }
        return max;
    }


}
