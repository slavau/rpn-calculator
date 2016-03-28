package com.rpn.calculator.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TokenTest {

    @Test
    public void willHoldValueOfToken() {
        assertThat(new Token("123", 1).getValue(), is("123"));
    }

    @Test
    public void willReturnTrueIfTokenIsOperand() {
        assertThat(new Token("123", 1).isOperand(), is(true));
    }

    @Test
    public void willReturnFalseIfTokenIsNotOperand() {
        assertThat(new Token("sqrt", 1).isOperand(), is(false));
    }

}