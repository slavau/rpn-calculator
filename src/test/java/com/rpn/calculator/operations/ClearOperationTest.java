package com.rpn.calculator.operations;

import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClearOperationTest {

    private ClearOperation operation = new ClearOperation();

    @Test
    public void willClearOperands() {
        Operands operands = new Operands();
        operands.add(Operand.valueOf(1));

        operation.perform(operands);

        assertThat(operands.size(), is(0));
    }
}