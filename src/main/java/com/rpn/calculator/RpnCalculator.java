package com.rpn.calculator;

import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.io.Token;
import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;
import com.rpn.calculator.operands.UndoManager;
import com.rpn.calculator.operations.AvailableOperations;
import com.rpn.calculator.operations.Operation;
import com.rpn.calculator.operations.UndoableOperation;

import java.util.List;
import java.util.Optional;

public class RpnCalculator {

    private final AvailableOperations availableOperations;
    private final Operands operands;
    private final UndoManager undoManager;

    public RpnCalculator(AvailableOperations availableOperations, Operands operands, UndoManager undoManager) {
        this.availableOperations = availableOperations;
        this.operands = operands;
        this.undoManager = undoManager;
    }

    public Result calculate(List<Token> tokens) {
        for(Token token : tokens) {
            try {
                processToken(token);
            } catch (InsufficientNumberOfParametersException ex) {
                return new Result(operands.retrieveCurrentState(), String.format("operator %s (position: %d): insufficient parameters", token.getValue(), token.getPosition()));
            }
        }

        return new Result(operands.retrieveCurrentState());
    }

    public void processToken(Token token) {
        if (token.isOperand()) {
            pushOntoTheStack(token);
        } else {
            pushResultBackOntoStack(performOperation(token));
        }
    }

    private Optional<Operand> performOperation(Token token) {
        Operation operation = availableOperations.getOperation(token.getValue());
        if(operation instanceof UndoableOperation) {
            operands.saveCurrentStateTo(undoManager);
        }

        return operation.perform(operands);
    }

    private void pushResultBackOntoStack(Optional<Operand> result) {
        if(result.isPresent()) {
            operands.add(result.get());
        }
    }

    private void pushOntoTheStack(Token token) {
        operands.saveCurrentStateTo(undoManager);

        operands.add(token.toOperand());
    }
}
