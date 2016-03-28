package com.rpn.calculator.operations;

import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import com.rpn.calculator.operands.UndoManager;

import java.util.Optional;

public class UndoOperation implements Operation {

    private final UndoManager undoManager;

    public UndoOperation(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public Optional<Operand> perform(Operands operands) {
        operands.restoreSavedStateFrom(undoManager);

        return Optional.empty();
    }

    public String getName() {
        return "undo";
    }
}
