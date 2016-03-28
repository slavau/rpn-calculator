package com.rpn.calculator.io;

import com.rpn.calculator.operands.Operand;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.math.NumberUtils;

public class Token {

    private final String value;
    private final int position;

    public Token(String value, int position) {
        this.value = value;
        this.position = position;
    }

    public boolean isOperand() {
        return NumberUtils.isDigits(value);
    }

    public Operand toOperand() {
        return new Operand(value);
    }

    public String getValue() {
        return value;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
