package com.rpn.calculator.io;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleOutputWriter {

    private final OutputStream outputStream;

    public ConsoleOutputWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        outputStream.write(content.getBytes());
    }
}
