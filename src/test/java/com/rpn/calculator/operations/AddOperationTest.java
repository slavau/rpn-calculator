package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddOperationTest {

    private AddOperation operation = new AddOperation();

    @Test(expected = InsufficientNumberOfParametersException.class)
    public void willAcceptOnlyTwoOperandsAsInput() {
        operation.perform(Operands.of(Operand.valueOf(1)));
    }

    @Test
    public void willPerformAddOperation() {
        Optional<Operand> operand = operation.perform(Operands.of(Operand.valueOf(1), Operand.valueOf(1)));
        assertThat(operand.get(), is(Operand.valueOf(2)));
    }
}