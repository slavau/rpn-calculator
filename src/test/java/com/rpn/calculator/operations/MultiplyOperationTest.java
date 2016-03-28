package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MultiplyOperationTest {

    private MultiplyOperation operation = new MultiplyOperation();

    @Test(expected = InsufficientNumberOfParametersException.class)
    public void willAcceptOnlyTwoOperands() {
        operation.perform(Operands.of(Operand.valueOf(1)));
    }

    @Test
    public void willPerformMultiplyOperationOnRealNumbers() {
        Optional<Operand> result = operation.perform(Operands.of(Operand.valueOf(2.5), Operand.valueOf(5)));

        assertThat(result.get(), is(Operand.valueOf(12.5)));
    }
}