package application.interpreter.instruction.simple;
import application.interpreter.exceptions.*;
import application.interpreter.expression.Expression;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import java.util.HashMap;

public class Assing extends Program {

    private String variableName;
    private Expression expression;

    public Assing(String variableName, Expression expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnauthorizedOperation {
        map.put(variableName, expression.eval(map));
    }

}

