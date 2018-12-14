package application.blocks;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class OperationBlock extends Block

{
    private TextField tvalue = new TextField();

    public OperationBlock(VBox languageBox, List<String> listButtonsNames, int defaultVariableNumber)
    {
        super(languageBox);
        this.setBackgroundColor("#EEEEEE");
        this.setBlockName("Wykonaj");


        HBox hb= new HBox();
        hb.setSpacing(10);

        tvalue.setPromptText("Wykonaj Operacje: ");

        hb.getChildren().add(tvalue);

        vb.getChildren().add(hb);
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        return tvalue.getText() + ";";
    }

    @Override
    public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {

    }

}