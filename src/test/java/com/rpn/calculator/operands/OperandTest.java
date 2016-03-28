package com.rpn.calculator.operands;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperandTest {

    @Test
    public void willPerformMultiply() {
        Operand op1 = Operand.valueOf(10);
        Operand op2 = Operand.valueOf(10);

        assertThat(op1.multiply(op2), is(Operand.valueOf(100)));
    }

    @Test
    public void willPerformDivide() {
        Operand op1 = Operand.valueOf(10);
        Operand op2 = Operand.valueOf(5);

        assertThat(op1.divide(op2), is(Operand.valueOf(2)));
    }

    @Test
    public void willPerformSubtract() {
        Operand op1 = Operand.valueOf(10);
        Operand op2 = Operand.valueOf(5);

        assertThat(op1.subtract(op2), is(Operand.valueOf(5)));
    }

    @Test
    public void willPerformAddition() {
        Operand op1 = Operand.valueOf(10);
        Operand op2 = Operand.valueOf(5);

        assertThat(op1.add(op2), is(Operand.valueOf(15)));
    }

    @Test
    public void willPerformSqrt() {
        Operand op1 = Operand.valueOf(9);

        assertThat(op1.sqrt(), is(Operand.valueOf(3)));
    }

    @Test
    public void willSupport15DecimalPlacesOfPrecision() {
        Operand op1 = new Operand("3.141592653589793238462643383279");

        assertThat(op1.toString(), is("3.141592653589793"));
    }

    @Test
    public void willFormatValueTo10DecimalPlacesOfPrecision() {
        Operand op1 = new Operand("3.141592653589793238462643383279");

        assertThat(op1.toFormattedString(), is("3.1415926535"));
    }

}