package application.blocks;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DoubleBlock extends Block
{
	public DoubleBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		this.setBackgroundColor("#71A6D2");
		this.setBlockName("Double");


		HBox hb= new HBox();
		hb.setSpacing(10);

		tname.setPromptText("Nazwa: ");
		tvalue.setPromptText("Wartość: ");

		tname.focusedProperty().addListener((arg0, oldValue, newValue) ->
		{
			if (!newValue)
			{
				if(oldName != null) variables.remove(oldName);
				if(!tname.getText().matches("^[a-zA-Z][a-zA-Z0-9_]*$"))
				{
					tname.setText("");
				}
                tname.setText(checkVariableName(tname.getText()));
                oldName=tname.getText();
			}

		});

		tvalue.focusedProperty().addListener((arg0, oldValue, newValue) ->
		{
			if (!newValue)
			{
				if(tvalue.getText().matches("^[a-zA-Z]*$"))
				{
					tvalue.setText("0.0");
				}
			}

		});

		hb.getChildren().add(tname);
		hb.getChildren().add(tvalue);

		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount)
	{
		if(tvalue.getText().isEmpty())
			return "double " + tname.getText() + ";";
		else
			return  "double " + tname.getText() + " = " + tvalue.getText() + ";";
	}

}