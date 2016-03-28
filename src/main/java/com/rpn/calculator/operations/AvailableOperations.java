package com.rpn.calculator.operations;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class AvailableOperations {

    private final Map<String, Operation> operations = newHashMap();

    public Operation getOperation(String name) {
        Operation operation = operations.get(name);
        if(operation == null) {
            throw new IllegalArgumentException(String.format("Unknown operation specified: %s", name));
        }
        return operation;
    }

    public void addOperation(Operation operation) {
        operations.put(operation.getName(), operation);
    }
}
