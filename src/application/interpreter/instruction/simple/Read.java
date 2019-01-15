package application.interpreter.instruction.simple;

import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.HashMap;
import java.util.Optional;

public class Read extends Program {

    private String var;

    public Read(String var){
        this.var = var;
    }


    @Override
    public void eval(HashMap<String, Value> map, TextArea console) throws UnknownOperator, VariableNotFound, IncompatibilityTypes, UnknownType {
    	String value = new String();
        TextInputDialog dialog = new TextInputDialog();
 
        dialog.setTitle("Read");
        dialog.setHeaderText("Read:");
        dialog.setContentText("read:");
 
        Optional<String> result = dialog.showAndWait();
        value = result.get();

        console.appendText(">> " + value + "\n");
        map.put(var, findType(value));
    }

    private Value findType(String number) throws UnknownType 
    {
        if(number.matches("-?\\d+(\\.\\d+)?"))
            return new Value("Double", Double.parseDouble(number));
        else if(number.matches("-?\\d+?"))
            return new Value("Integer", Integer.parseInt(number));
        else
            return new Value("String", number);
    }
}
