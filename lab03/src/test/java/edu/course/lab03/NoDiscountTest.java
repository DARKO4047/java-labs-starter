
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoDiscountTest {

    @Test
    public void testNoDiscount() {
        NoDiscount discount = new NoDiscount();

        assertEquals(100.0, discount.apply(100.0), 0.001);
    }

    @Test
    public void testNoDiscountWithZeroPrice() {
        NoDiscount discount = new NoDiscount();

        assertEquals(0.0, discount.apply(0.0), 0.001);
    }
}
