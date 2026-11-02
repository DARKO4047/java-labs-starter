
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercentDiscountTest {

    @Test
    public void testTwentyPercentDiscount() {
        PercentDiscount discount = new PercentDiscount(20);

        assertEquals(80.0, discount.apply(100.0), 0.001);
    }

    @Test
    public void testTenPercentDiscount() {
        PercentDiscount discount = new PercentDiscount(10);

        assertEquals(180.0, discount.apply(200.0), 0.001);
    }

    @Test
    public void testInvalidPercent() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(120));
    }

    @Test
    public void testNegativePercent() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(-10));
    }

    @Test
    public void testNegativePrice() {
        PercentDiscount discount = new PercentDiscount(20);

        assertThrows(IllegalArgumentException.class,
                () -> discount.apply(-100));
    }

    @Test
    public void testHundredPercentDiscount() {
        PercentDiscount discount = new PercentDiscount(100);

        assertEquals(0.0, discount.apply(100.0), 0.001);
    }
}
