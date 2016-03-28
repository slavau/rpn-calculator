package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;

import java.util.Optional;

public class SqrtOperation implements UndoableOperation {

    public Optional<Operand> perform(Operands operands) {
        if(!operands.validateSizeIsAtLeast(1)) {
            throw new InsufficientNumberOfParametersException("Sqrt accepts one operand!");
        }

        return Optional.of(operands.getNext().sqrt());
    }

    public String getName() {
        return "sqrt";
    }
}
