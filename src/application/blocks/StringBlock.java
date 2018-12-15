package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class StringBlock extends Block
{
	private TextField tname = new TextField();
	private TextField tvalue = new TextField();
    String oldName = null;

	public StringBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		this.setBackgroundColor("#FC5D5D");
		this.setBlockName("String");


		HBox hb= new HBox();
		hb.setSpacing(10);

		tname.setPromptText("Nazwa: ");
		tvalue.setPromptText("Warto??: ");

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

		hb.getChildren().add(tname);
		hb.getChildren().add(tvalue);

		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount)
	{
		if(tvalue.getText().isEmpty())
			return "String " + tname.getText() + ";";
		else
			return "String " + tname.getText() + " = \"" + tvalue.getText() + "\";";
	}

}
