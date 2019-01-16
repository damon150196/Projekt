package application.interpreter.instruction.simple;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.instruction.program.Program;
import application.interpreter.expression.Value;
import javafx.scene.control.TextArea;


import java.util.HashMap;

public class WriteFromCode extends Program {

    private String var;

    public WriteFromCode(String var) {
        this.var = var;
    }

    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType {

        console.appendText(var);
        System.out.println(var);
    }
}