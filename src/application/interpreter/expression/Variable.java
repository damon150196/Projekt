package application.interpreter.expression;

import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.VariableNotFound;

import java.util.HashMap;

public class Variable extends Expression{

    private String variableName;

    public Variable(String variableName){
        this.variableName = variableName;
    }


    @Override
    public Value eval(HashMap<String, Value> map) throws UnknownOperator, VariableNotFound {
        if(!map.containsKey(variableName))
            throw new VariableNotFound();
        return map.get(variableName);
    }
}
