package com.rpn.calculator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Result {

    private final List<String> calculatedResult;
    private final String errorMessage;

    public Result(List<String> calculatedResult, String errorMessage) {
        this.calculatedResult = calculatedResult;
        this.errorMessage = errorMessage;
    }

    public Result(List<String> calculatedResult) {
        this(calculatedResult, "");
    }

    public List<String> getCalculatedResult() {
        return calculatedResult;
    }

    public String getErrorMessage() {
        return errorMessage;
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
