package application.interpreter.instruction.complex;

import application.interpreter.exceptions.*;
import application.interpreter.expression.Expression;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import java.util.HashMap;

public class If extends Program {

    private Program branchThen, branchElse;
    private Expression condition;

    public If(Expression condition, Program branchThen, Program branchElse) {
        this.condition = condition;
        this.branchThen = branchThen;
        this.branchElse = branchElse;
    }

    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType, UnauthorizedOperation {
        if (!condition.eval(map).getNumber().equals(0) && !condition.eval(map).getNumber().equals(0.0))
            branchThen.eval(map, console);
        else
            branchElse.eval(map, console);
    }

}
