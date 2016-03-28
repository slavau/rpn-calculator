package com.rpn.calculator.operations;

import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;

import java.util.Optional;

public class ClearOperation implements UndoableOperation {

    public Optional<Operand> perform(Operands operands) {
        operands.clear();

        return Optional.empty();
    }

    public String getName() {
        return "clear";
    }
}
