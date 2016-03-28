package com.rpn.calculator.operations;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;

import java.util.Optional;

public class SubtractOperation implements UndoableOperation {

    public Optional<Operand> perform(Operands operands) {
        if(!operands.validateSizeIsAtLeast(2)) {
            throw new InsufficientNumberOfParametersException("Subtract accepts two operands!");
        }

        Operand operand2 = operands.getNext();
        Operand operand1 = operands.getNext();
        return Optional.of(operand1.subtract(operand2));
    }

    public String getName() {
        return "-";
    }
}
