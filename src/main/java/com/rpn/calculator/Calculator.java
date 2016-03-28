package com.rpn.calculator;

import com.google.common.base.Joiner;
import com.rpn.calculator.io.ConsoleInputReader;
import com.rpn.calculator.io.ConsoleOutputWriter;
import com.rpn.calculator.io.Token;
import com.rpn.calculator.operands.Operands;
import com.rpn.calculator.operands.UndoManager;
import com.rpn.calculator.operations.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final String CR = "\n";

    private final ConsoleInputReader inputReader;
    private final ConsoleOutputWriter outputWriter;
    private final RpnCalculator rpnCalculator;

    public Calculator(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, RpnCalculator rpnCalculator) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.rpnCalculator = rpnCalculator;
    }

    public static void main(String[] args) throws IOException {
        // Dependency injection.
        ConsoleInputReader inputReader = new ConsoleInputReader(new Scanner(System.in));
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter(System.out);

        UndoManager undoManager = new UndoManager();
        AvailableOperations availableOperations = new AvailableOperations();
        availableOperations.addOperation(new SubtractOperation());
        availableOperations.addOperation(new AddOperation());
        availableOperations.addOperation(new MultiplyOperation());
        availableOperations.addOperation(new DivideOperation());
        availableOperations.addOperation(new SqrtOperation());
        availableOperations.addOperation(new ClearOperation());
        availableOperations.addOperation(new UndoOperation(undoManager));

        RpnCalculator rpnCalculator = new RpnCalculator(availableOperations, new Operands(), undoManager);

        new Calculator(inputReader, outputWriter, rpnCalculator).run();
    }

    public void run() throws IOException {
        List<Token> tokens;
        while (!(tokens = inputReader.getTokens()).isEmpty()) {
            Result result = calculate(tokens);
            outputWriter.write(buildOutputMessage(result));
        }
    }

    private String buildOutputMessage(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        if (StringUtils.isNotBlank(result.getErrorMessage())) {
            stringBuilder.append(result.getErrorMessage());
            stringBuilder.append(CR);
        }

        stringBuilder.append("Stack: ");
        stringBuilder.append(Joiner.on(" ").join(result.getCalculatedResult()));
        stringBuilder.append(CR);
        return stringBuilder.toString();
    }

    public Result calculate(List<Token> tokens) {
        return rpnCalculator.calculate(tokens);
    }
}
