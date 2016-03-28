package com.rpn.calculator.io;

import com.google.common.collect.Iterables;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsoleInputReaderTest {

    private ConsoleInputReader consoleInputReader;

    @Test
    public void willReadInputAndReturnListOfTokens() {
        String input = "123 456 789";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        consoleInputReader = new ConsoleInputReader(scanner);

        Token token1 = new Token("123", 1);
        Token token2 = new Token("456", 3);
        Token token3 = new Token("789", 5);
        List<Token> expected = newArrayList(token1, token2, token3);

        assertThat(Iterables.elementsEqual(expected, consoleInputReader.getTokens()), is(true));
    }

}