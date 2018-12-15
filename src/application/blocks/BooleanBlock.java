package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BooleanBlock extends Block 
{
    private TextField tname = new TextField();
    private TextField tvalue = new TextField();
    String oldName = null;

    public BooleanBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#2e8b57");
        this.setBlockName("Boolean");


        HBox hb = new HBox();
        hb.setSpacing(10);

        tname.setPromptText("Nazwa: ");
        tvalue.setPromptText("Wartoœæ: ");

        tname.focusedProperty().addListener((arg0, oldValue, newValue) ->
        {
            if (!newValue) 
            {
                if (!tname.getText().matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
                    tname.setText("");
                }
                checkVariableName(tname.getText());
				variables.add(tname.getText());
            }

        });

        tvalue.focusedProperty().addListener((arg0, oldValue, newValue) ->
        {
            if (!newValue) 
            {
            	if(oldName != null) variables.remove(oldName);
                if (!(tvalue.getText().matches("1") || tvalue.getText().matches("0"))) 
                {
                    tvalue.setText("0");
                }
                tname.setText(checkVariableName(tname.getText()));
                oldName=tname.getText();
            }
        });

        hb.getChildren().add(tname);
        hb.getChildren().add(tvalue);

        vb.getChildren().add(hb);
    }


    @Override
    public String getFunctionString(int tabCount) {
        if (tvalue.getText().isEmpty())
            return "boolean " + tname.getText() + ";";
        else
            return "boolean " + tname.getText() + " = " + tvalue.getText() + ";";
    }

}
