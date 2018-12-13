package application.interpreter.expression;

import application.interpreter.exceptions.UnknownType;

import java.util.HashMap;

public class Constant extends Expression {

    private Value constantValue;

    public Constant(Number number) throws UnknownType {
        this.constantValue = new Value(findType(number),number);
    }


    @Override
    public Value eval(HashMap<String, Value> map) {
        return constantValue;
    }



    private String findType(Number number){
        if(number.toString().contains("."))
            return "Double";
        else
            return "Integer";
    }
}

