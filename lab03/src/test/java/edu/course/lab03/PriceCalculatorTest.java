
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void testCalculatorWithNoDiscount() {
        PriceCalculator calculator =
                new PriceCalculator(new NoDiscount());

        assertEquals(100.0, calculator.calculate(100.0), 0.001);
    }

    @Test
    public void testCalculatorWithPercentDiscount() {
        PriceCalculator calculator =
                new PriceCalculator(new PercentDiscount(20));

        assertEquals(80.0, calculator.calculate(100.0), 0.001);
    }

    @Test
    public void testReplaceDiscountPolicy() {
        PriceCalculator calculator1 =
                new PriceCalculator(new NoDiscount());

        PriceCalculator calculator2 =
                new PriceCalculator(new PercentDiscount(50));

        assertEquals(100.0, calculator1.calculate(100.0), 0.001);
        assertEquals(50.0, calculator2.calculate(100.0), 0.001);
    }
}
