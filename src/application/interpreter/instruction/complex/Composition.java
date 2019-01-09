package application.interpreter.instruction.complex;

import application.interpreter.exceptions.*;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;
import javafx.scene.control.TextArea;

import java.util.HashMap;

public class Composition extends Program {

    private Program left, right;

    public Composition(Program left, Program right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType, UnauthorizedOperation {
        left.eval(map, console);
        right.eval(map, console);
    }
}