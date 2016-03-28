package com.rpn.calculator.operands;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperandsTest {

    private Operands operands;

    @Test
    public void shouldCheckSizeOfOperands() {
        operands = Operands.of(Operand.valueOf(1));

        assertThat(operands.validateSizeIsAtLeast(1), is(true));
    }

    @Test
    public void willSupportAddOperation() {
        operands = Operands.of(Operand.valueOf(1));

        assertThat(operands.getNext(), is(Operand.valueOf(1)));
    }

    @Test
    public void willSupportRetrieveCurrentStateOperation() throws IOException {
        operands = Operands.of(Operand.valueOf(1), Operand.valueOf(2), Operand.valueOf(3.141592653589793));

        List<String> expectedState = newArrayList("1", "2", "3.1415926535");
        assertThat(operands.retrieveCurrentState(), is(expectedState));
    }

    @Test(expected = IllegalStateException.class)
    public void willSupportClearOperation() {
        Operand operand1 = Operand.valueOf(1);
        Operand operand2 = Operand.valueOf(1);

        operands = Operands.of(operand1, operand2);
        operands.clear();

        operands.getNext();
    }
}
