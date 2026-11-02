package edu.course.lab03;

public class PercentDiscount implements DiscountPolicy{
    private final double percent;
    public PercentDiscount (double percent){
        if (percent < 0.0 || percent > 100.0){
            throw new IllegalArgumentException("Некоррекктное значение скидки");
        }
        this.percent = percent;
    }
    @Override
    public double apply(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицатеьной");
        }
        return (price - (price*percent/100));
    }
}
