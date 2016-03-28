package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SqrtOperationTest {

    private SqrtOperation operation = new SqrtOperation();

    @Test(expected = InsufficientNumberOfParametersException.class)
    public void willAcceptOnlyOneOperand() {
        operation.perform(new Operands());
    }

    @Test
    public void willPerformSqrtOperation() {
        Optional<Operand> result = operation.perform(Operands.of(Operand.valueOf(9)));

        assertThat(result.get(), is(Operand.valueOf(3)));
    }
}
