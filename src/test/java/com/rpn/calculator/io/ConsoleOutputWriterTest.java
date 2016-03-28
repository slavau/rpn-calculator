package com.rpn.calculator.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.OutputStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleOutputWriterTest {

    @Mock
    private OutputStream outputStream;
    @InjectMocks
    private ConsoleOutputWriter writer;

    @Test
    public void willDelegateToUnderlingStream() throws IOException {
        writer.write("content");

        verify(outputStream).write("content".getBytes());
    }

}