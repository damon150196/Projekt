package application.interpreter.instruction.complex;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.Expression;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import java.util.HashMap;

public class While extends Program{

    private Program body;
    private Expression condition;

    public While(Expression condition, Program body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType {
        if(!condition.eval(map).getNumber().equals(0)){
            body.eval(map, console);
            this.eval(map, console);
        }
    }
}
