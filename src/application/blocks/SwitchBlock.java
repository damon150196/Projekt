package application.blocks;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SwitchBlock extends Block {

    TextField tname = new TextField();
	public SwitchBlock(VBox languageBox, List<String> listButtonsNames, int defaultVariableNumber)
    {
        super(languageBox);
        this.setBackgroundColor("#AE99DC");
        this.setBlockName("Switch");
        this.setPadding(new Insets(5,0,5,0));

        tname.setPromptText("Nazwa Zmiennej: ");
        tname.focusedProperty().addListener((arg0, oldValue, newValue) ->
        {

            if (!newValue) {
                if (!tname.getText().matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {

                    tname.setText("");
                }
                    checkVariableName(tname.getText(), listButtonsNames, defaultVariableNumber);

            }

        });

        vb.getChildren().add(tname);
        vb.getChildren().add(new ButtonBlock(" +  ", vb, lb, 0, listButtonsNames, defaultVariableNumber));

        content.setBottom(vb);
    }

	@Override
	public String getFunctionString(int tabCount) 
	{
		StringBuilder sb = new StringBuilder("switch(" + tname.getText() + ")\n{\n");

		for(int i=1; i <  vb.getChildren().size(); i++)
		{
			if( vb.getChildren().get(i) instanceof Block)
			{
				sb.append(tabs(tabCount+1));
				Block b = (Block) vb.getChildren().get(i);
				sb.append(b.getFunctionString(tabCount+1) + "\n");
			}
		}
		sb.append("}");

		return sb.toString();
	}

	@Override
	public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {
		// TODO Auto-generated method stub

	}

}
