package application.interpreter.expression;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownType;

import java.util.ArrayList;
import java.util.Arrays;

public class Value {

    private String type;
    private Number number;


    public Value(String type, Number number) throws UnknownType {
        if (!checkType(type))
            throw new UnknownType();
        this.type = type;
        this.number = number;
    }

    private Value(String type) {
        this.type = type;
        this.number = null;
    }


    public static boolean checkType(String type) {
        ArrayList<String> allowedTypes = new ArrayList<String>(Arrays.asList("Integer", "Double"));
        return allowedTypes.contains(type);
    }


    public Value addition(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() + value.number.intValue());
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() + value.number.doubleValue());
                break;
            }
        }
        return newValue;
    }

    public Value subtraction(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() - value.number.intValue());
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() - value.number.doubleValue());
                break;
            }
        }
        return newValue;
    }


    public Value multiplication(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() * value.number.intValue());
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() * value.number.doubleValue());
                break;
            }
        }
        return newValue;
    }

    public Value division(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() / value.number.intValue());
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() / value.number.doubleValue());
                break;
            }
        }
        return newValue;
    }

    public Value modulo(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() % value.number.intValue());
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() % value.number.doubleValue());
                break;
            }
        }
        return newValue;
    }

    private void checkIfTypeIsCompatibility(Value value) throws IncompatibilityTypes {
        if (!type.equals(value.type))
            throw new IncompatibilityTypes();
    }

    public Value greater(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() > value.number.intValue() ? 1 : 0);
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue()>value.number.doubleValue() ? 1.0 : 0.0);
                break;
            }
        }
        return newValue;
    }

    public Value smaller(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() > value.number.intValue() ? 0 : 1);
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue()>value.number.doubleValue() ? 0.0 : 1.0);
                break;
            }
        }
        return newValue;
    }

    public Value equal(Value value) throws IncompatibilityTypes {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() == value.number.intValue() ? 1 : 0);
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() == value.number.doubleValue() ? 1.0 : 0.0);
                break;
            }
        }
        return newValue;
    }



    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }
}