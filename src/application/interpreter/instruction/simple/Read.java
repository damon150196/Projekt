package application.interpreter.instruction.simple;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import java.util.HashMap;
import java.util.Scanner;

public class Read extends Program {

    private String var;

    public Read(String var){
        this.var = var;
    }


    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType {
        Scanner scanner = new Scanner(System.in);
        map.put(var, findType(scanner.nextLine()));
    }

    private Value findType(String number) throws UnknownType {
        if(number.contains("."))
            return new Value("Double", Double.parseDouble(number));
        else
            return new Value("Integer", Integer.parseInt(number));
    }
}
