package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DivideOperationTest {

    private DivideOperation operation = new DivideOperation();

    @Test(expected = InsufficientNumberOfParametersException.class)
    public void willOnlyAcceptTwoOperands() {
        operation.perform(Operands.of(Operand.valueOf(1)));
    }

    @Test
    public void willPerformDivideOperation() {
        Optional<Operand> result = operation.perform(Operands.of(Operand.valueOf(10), Operand.valueOf(2)));

        assertThat(result.get(), is(Operand.valueOf(5)));
    }

    @Test
    public void willPerformDivideWithRealNumbers() {
        Optional<Operand> result = operation.perform(Operands.of(Operand.valueOf(10), Operand.valueOf(4)));

        assertThat(result.get(), is(Operand.valueOf(2.5)));
    }
}