package com.rpn.calculator;

import com.google.common.collect.Lists;
import com.rpn.calculator.exception.InsufficientNumberOfParametersException;
import com.rpn.calculator.io.Token;
import com.rpn.calculator.operands.Operands;
import com.rpn.calculator.operands.UndoManager;
import com.rpn.calculator.operations.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

public class RpnCalculatorTest {

    private AvailableOperations availableOperations = new AvailableOperations();
    private Operands operands = new Operands();
    private UndoManager undoManager = new UndoManager();

    private RpnCalculator rpnCalculator;

    @Before
    public void setUp() {
        rpnCalculator = spy(new RpnCalculator(availableOperations, operands, undoManager));

        availableOperations.addOperation(new SubtractOperation());
        availableOperations.addOperation(new AddOperation());
        availableOperations.addOperation(new MultiplyOperation());
        availableOperations.addOperation(new DivideOperation());
        availableOperations.addOperation(new SqrtOperation());
        availableOperations.addOperation(new ClearOperation());
    }

    @Test
    public void willCalculateResultBasedOnInputTokens() {
        List<Token> tokens = newArrayList(
                new Token("5", 1),
                new Token("1", 2),
                new Token("2", 3),
                new Token("+", 4),
                new Token("4", 5),
                new Token("*", 6),
                new Token("+", 7),
                new Token("3", 8),
                new Token("-", 9)
        );

        assertThat(rpnCalculator.calculate(tokens), equalTo(new Result(newArrayList("14"))));
    }

    @Test
    public void calculateWillReturnErrorMessageWhenExceptionIsThrown() {
        Token token = new Token("*", 1);
        doThrow(InsufficientNumberOfParametersException.class).when(rpnCalculator).processToken(token);

        assertThat(rpnCalculator.calculate(newArrayList(token)), equalTo(new Result(Lists.<String>newArrayList(), "operator * (position: 1): insufficient parameters")));
    }
}