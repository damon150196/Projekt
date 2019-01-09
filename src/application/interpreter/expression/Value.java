package application.interpreter.expression;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnauthorizedOperation;
import application.interpreter.exceptions.UnknownType;

import java.util.ArrayList;
import java.util.Arrays;

public class Value {

    private String type;
    private Number number;
    private String string;

    public Value(String type, Number number) throws UnknownType {
        if (!checkType(type))
            throw new UnknownType();
        this.type = type;
        this.number = number;
    }

    public Value(String type, String value) throws UnknownType {
        if (!checkType(type))
            throw new UnknownType();
        this.type = type;
        this.string = value;
    }

    private Value(String type) {
        this.type = type;
        this.number = null;
    }

    public static boolean checkType(String type) {
        ArrayList<String> allowedTypes = new ArrayList<String>(Arrays.asList("Integer", "Double", "String"));
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
            case "String": {
                newValue.setString(string + value.string);
            }
        }
        return newValue;
    }

    public Value subtraction(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
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
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }


    public Value multiplication(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
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
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value division(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
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
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value modulo(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
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
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    private void checkIfTypeIsCompatibility(Value value) throws IncompatibilityTypes {
        if (!type.equals(value.type))
            throw new IncompatibilityTypes();
    }

    public Value greater(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() > value.number.intValue() ? 1 : 0);
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() > value.number.doubleValue() ? 1.0 : 0.0);
                break;
            }
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value smaller(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber(number.intValue() > value.number.intValue() ? 0 : 1);
                break;
            }
            case "Double": {
                newValue.setNumber(number.doubleValue() > value.number.doubleValue() ? 0.0 : 1.0);
                break;
            }
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value equal(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
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
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value and(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber((number.intValue() != 0 && value.number.intValue() != 0) ? 1 : 0);
                break;
            }
            case "Double": {
                newValue.setNumber((number.doubleValue() != 0.0 && value.number.doubleValue() != 0.0) ? 1.0 : 0.0);
                break;
            }
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }

    public Value or(Value value) throws IncompatibilityTypes, UnauthorizedOperation {
        checkIfTypeIsCompatibility(value);

        Value newValue = new Value(type);

        switch (type) {
            case "Integer": {
                newValue.setNumber((number.intValue() != 0 || value.number.intValue() != 0) ? 1 : 0);
                break;
            }
            case "Double": {
                newValue.setNumber((number.doubleValue() != 0.0 || value.number.doubleValue() != 0.0) ? 1.0 : 0.0);
                break;
            }
            default: {
                throw new UnauthorizedOperation();
            }
        }
        return newValue;
    }


    public Number getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }

    public boolean isString(){
        return type.equals("String");
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public void setString(String string) {
        this.string = string;
    }
}
