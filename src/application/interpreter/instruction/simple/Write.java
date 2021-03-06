package application.interpreter.instruction.simple;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;
import javafx.scene.control.TextArea;

import java.util.HashMap;

public class Write  extends Program {

    private String var;

    public Write(String var){
        this.var = var;
    }


    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType {
        if(!map.containsKey(var))
            throw new VariableNotFound();

        if(map.get(var).isString()){
            console.appendText(String.valueOf(map.get(var).getString()));
            console.appendText("\n");
            System.out.println();        }
        else {
            console.appendText(String.valueOf(map.get(var).getNumber()));
            console.appendText("\n");
            System.out.println();        }

        /*console.appendText(String.valueOf(map.get(var).getNumber()));
        console.appendText("\n");
        System.out.println();*/
    }


}
