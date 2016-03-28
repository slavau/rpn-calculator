package com.rpn.calculator;

import com.rpn.calculator.io.ConsoleInputReader;
import com.rpn.calculator.io.ConsoleOutputWriter;
import com.rpn.calculator.io.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private ConsoleInputReader inputReader;
    @Mock
    private ConsoleOutputWriter outputWriter;
    @Mock
    private RpnCalculator rpnCalculator;

    @InjectMocks
    private Calculator calculator;

    @Test
    public void willDelegateExecutionToRpnCalculator() throws IOException {
        List<Token> tokens = newArrayList(new Token("3", 1), new Token("2", 2), new Token("-", 3));
        when(inputReader.getTokens()).thenReturn(tokens);

        calculator.calculate(tokens);

        verify(rpnCalculator).calculate(tokens);
    }

    @Test
    public void willPrintResultToOutputStream() throws IOException {
        Result result = new Result(newArrayList("1"));
        List<Token> tokens = newArrayList(new Token("3", 1), new Token("2", 2), new Token("-", 3));
        when(inputReader.getTokens()).thenReturn(tokens, getEmptyTokens());
        when(rpnCalculator.calculate(tokens)).thenReturn(result);

        calculator.run();

        verify(outputWriter).write("Stack: 1\n");
    }

    @Test
    public void willPrintResultWithErrorToOutputStream() throws IOException {
        Result result = new Result(newArrayList("1"), "Error");
        List<Token> tokens = newArrayList(new Token("1", 1));
        when(inputReader.getTokens()).thenReturn(tokens, getEmptyTokens());
        when(rpnCalculator.calculate(tokens)).thenReturn(result);

        calculator.run();

        verify(outputWriter).write("Error\nStack: 1\n");
    }


    private List<Token> getEmptyTokens() {
        return newArrayList();
    }
}
