package application.interpreter.expression;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnauthorizedOperation;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.VariableNotFound;

import java.util.HashMap;

abstract public class Expression {

    public abstract Value eval(HashMap<String, Value> map) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnauthorizedOperation;

}
