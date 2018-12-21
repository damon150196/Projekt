package application.blocks;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class OperationBlock extends Block
{

    public OperationBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
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


}