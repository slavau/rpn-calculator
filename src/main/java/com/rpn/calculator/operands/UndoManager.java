package com.rpn.calculator.operands;

import java.util.Stack;

public class UndoManager {

    private final Stack<OperandsState> historyStack = new Stack<OperandsState>();

    public void saveState(OperandsState state) {
        historyStack.push(state);
    }

    public OperandsState restoreState() {
        return historyStack.pop();
    }
}
