package application.interpreter.expression;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;

import java.util.HashMap;

public class NewString extends Expression {

    private Value stringValue;

    public NewString(String value) throws UnknownType {
        this.stringValue = new Value("String",value);
    }

    @Override
    public Value eval(HashMap<String, Value> map) throws UnknownOperator, VariableNotFound, IncompatibilityTypes {
        return stringValue;
    }
}
