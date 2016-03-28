package com.rpn.calculator.io;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Scanner;

import static com.google.common.collect.Lists.newArrayList;

public class ConsoleInputReader {

    private final Scanner scanner;

    public ConsoleInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<Token> getTokens() {
        String line = scanner.nextLine();

        return buildTokens(Splitter.onPattern("\\s+").trimResults().omitEmptyStrings().split(line));
    }

    private List<Token> buildTokens(Iterable<String> split) {
        List<Token> tokens = newArrayList();
        int position = 1;
        for (String value : split) {
            tokens.add(new Token(value, position));
            position += 2;
        }
        return tokens;
    }
}
