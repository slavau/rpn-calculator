package com.rpn.calculator.operations;

import com.rpn.calculator.operands.Operand;
import com.rpn.calculator.operands.Operands;

import java.util.Optional;

public interface Operation {

    Optional<Operand> perform(Operands operands);

    String getName();

}
