package edu.course.lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);
        assertTrue(result);
    }
    @Test
    void isPrimeReturnsTrueForTwo() {
        boolean result = CourseToolkit.isPrime(2);
        assertTrue(result);
    }

    @Test
    void isPrimeReturnsFalseForSquareOfPrime() {
        boolean result = CourseToolkit.isPrime(9);
        assertFalse(result);
    }

    @Test
    void isPrimeReturnsFalseForOddComposite() {
        boolean result = CourseToolkit.isPrime(15);
        assertFalse(result);
    }

    @Test
    void isPrimeReturnsTrueForLargePrime() {
        boolean result = CourseToolkit.isPrime(17);
        assertTrue(result);
    }
    @Test
    void isPalindromeReturnsTrueForNormalWord() {
        boolean result = CourseToolkit.isPalindrome("анна");
        assertTrue(result);
    }

    @Test
    void isPalindromeReturnsTrueForMixedCase() {
        boolean result = CourseToolkit.isPalindrome("Дед");
        assertTrue(result);
    }

    @Test
    void isPalindromeReturnsFalseForNonPalindrome() {
        boolean result = CourseToolkit.isPalindrome("Арбуз");
        assertFalse(result);
    }
    @Test
    void averageReturnsCorrectDecimalValue() {
        int[] values = {1, 2, 3, 4};
        double result = CourseToolkit.average(values);
        assertEquals(2.5, result);
    }

    @Test
    void averageWorksWithNegativeNumbers() {
        int[] values = {-5, -10, -15};
        double result = CourseToolkit.average(values);
        assertEquals(-10.0, result);
    }

    @Test
    void averageThrowsExceptionForEmptyArray() {
        int[] values = new int [0];
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(values));
    }
    @Test
    void minReturnsMinimumInMixedArray() {
        int[] list = {10, -3, 25, 0, -15, 8};
        assertEquals(-15, CourseToolkit.Min(list));
    }

    @Test
    void minReturnsElementForSingleElementArray() {
        int[] list = {5};
        assertEquals(5, CourseToolkit.Min(list));
    }

    @Test
    void minThrowsExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.Min(null));
    }

    @Test
    void maxReturnsMaximumInMixedArray() {
        int[] list = {10, -3, 25, 0, -15, 8};
        assertEquals(25, CourseToolkit.Max(list));
    }

    @Test
    void maxReturnsElementForSingleElementArray() {
        int[] list = {-8};
        assertEquals(-8, CourseToolkit.Max(list));
    }

    @Test
    void maxThrowsExceptionForEmptyArray() {
        int[] list = new int[0];
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.Max(list));
    }
}
