package application.interpreter.instruction.program;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.Value;
import javafx.scene.control.TextArea;


import java.util.HashMap;

public abstract class Program {

    public abstract void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType;

}
