package application.interpreter.instruction.simple;

import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;

import javafx.scene.control.TextArea;
import java.util.HashMap;

public class Skip extends Program {
    @Override
    public void eval(HashMap<String, Value> map, TextArea console) { }
}
