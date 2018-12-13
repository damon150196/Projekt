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

        console.appendText("Rezultat wykonanego programu to: \n");
        console.appendText(String.valueOf(map.get(var).getNumber()));
    }


}
