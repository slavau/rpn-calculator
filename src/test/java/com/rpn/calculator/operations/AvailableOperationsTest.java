package com.rpn.calculator.operations;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AvailableOperationsTest {

    private AvailableOperations availableOperations = new AvailableOperations();

    @Test(expected = IllegalArgumentException.class)
    public void getOperationWillThrowAnErrorForUnknownOperation() {
        availableOperations.getOperation("unknown");
    }

    @Test
    public void willSupportAddOperation() {
        Operation operation = new SqrtOperation();
        availableOperations.addOperation(operation);

        assertThat(availableOperations.getOperation("sqrt"), equalTo(operation));
    }
}