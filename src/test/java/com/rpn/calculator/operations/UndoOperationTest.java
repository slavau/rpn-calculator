package com.rpn.calculator.operations;

import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import com.rpn.calculator.operands.UndoManager;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UndoOperationTest {

    private UndoManager undoManager = new UndoManager();

    private UndoOperation operation = new UndoOperation(undoManager);

    @Test
    public void willUndoToThePreviousState() {
        Operands operands = new Operands();
        addToStack(operands, Operand.valueOf(1), undoManager);
        addToStack(operands, Operand.valueOf(10), undoManager);

        operation.perform(operands);

        assertThat(operands.getNext(), equalTo(Operand.valueOf(10)));
    }

    private void addToStack(Operands operands, Operand operand, UndoManager undoManager) {
        operands.add(operand);
        operands.saveCurrentStateTo(undoManager);
    }
}