package com.rpn.calculator.operands;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class Operands {

    private static final Function<String, Operand> TO_OPERANDS = Operand::new;
    private static final Function<Operand, String> TO_FORMATTED_STRING = Operand::toFormattedString;
    private static final String SEPARATOR = ";";

    private Stack<Operand> stack = new Stack<>();

    public void add(Operand operand) {
        stack.push(operand);
    }

    public Operand getNext() {
        if (stack.empty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }

    public boolean validateSizeIsAtLeast(int size) {
        return stack.size() >= size;
    }

    public static Operands of(Operand... operands) {
        Operands newOperands = new Operands();
        for (Operand operand : operands) {
            newOperands.stack.push(operand);
        }
        return newOperands;
    }

    public void saveCurrentStateTo(UndoManager undoManager) {
        List<String> stackContent = newArrayList();
        stackContent.addAll(stack.stream().map(Operand::toString).collect(Collectors.toList()));

        undoManager.saveState(new OperandsState(Joiner.on(SEPARATOR).join(stackContent)));
    }

    public void restoreSavedStateFrom(UndoManager undoManager) {
        OperandsState operandsState = undoManager.restoreState();

        List<Operand> items = newArrayList(from(Splitter.on(SEPARATOR).split(operandsState.getState())).transform(TO_OPERANDS));
        stack = new Stack<>();
        items.forEach(stack::push);
    }

    public List<String> retrieveCurrentState() {
        return from(stack).transform(TO_FORMATTED_STRING).toList();
    }
}
