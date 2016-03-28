package com.rpn.calculator.operands;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Operand {

    public static final int SCALE = 15;
    public static final int ROUNDING_MODE = BigDecimal.ROUND_FLOOR;

    private final BigDecimal value;

    public Operand(String value) {
        this(new BigDecimal(value));
    }

    private Operand(BigDecimal value) {
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public Operand add(Operand operand) {
        return new Operand(this.value.add(operand.value));
    }

    public Operand subtract(Operand operand) {
        return new Operand(this.value.subtract(operand.value));
    }

    public Operand multiply(Operand operand) {
        return new Operand(this.value.multiply(operand.value));
    }

    public Operand divide(Operand operand) {
        return new Operand(this.value.divide(operand.value, SCALE, ROUNDING_MODE));
    }

    public Operand sqrt() {
        BigDecimal TWO = BigDecimal.valueOf(2);

        // Obtain the first approximation
        BigDecimal x = this.value
                .divide(BigDecimal.valueOf(3), SCALE, BigDecimal.ROUND_UP);
        BigDecimal lastX = BigDecimal.valueOf(0);

        // Proceed through 50 iterations
        for (int i = 0; i < 50; i++) {
            x = this.value.add(x.multiply(x)).divide(x.multiply(TWO), SCALE, BigDecimal.ROUND_UP);
            if (x.compareTo(lastX) == 0)
                break;
            lastX = x;
        }
        return new Operand(x);
    }

    public String toFormattedString() {
        DecimalFormat df = new DecimalFormat("#0.##########");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(value);
    }

    public static Operand valueOf(double value) {
        return new Operand(String.valueOf(value));
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Operand && this.value.equals(((Operand) that).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
