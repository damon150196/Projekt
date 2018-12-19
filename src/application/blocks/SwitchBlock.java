package application.blocks;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class SwitchBlock extends Block 
{
	public SwitchBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
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

            }

        });

        vb.getChildren().add(tname);
        vb.getChildren().add(new ButtonBlock(" +  ", vb, lb, 0, variables));

        content.setBottom(vb);
    }

	@Override
	public String getFunctionString(int tabCount) 
	{
		StringBuilder sb = new StringBuilder("switch(" + tname.getText() + ")\n");

		sb.append(tabs(tabCount));
		sb.append("{\n");

		for(int i=1; i <  vb.getChildren().size(); i++)
		{
			if( vb.getChildren().get(i) instanceof Block)
			{
				sb.append(tabs(tabCount+1));
				Block b = (Block) vb.getChildren().get(i);
				sb.append(b.getFunctionString(tabCount+1) + "\n");
			}
		}
		sb.append(tabs(tabCount));
		sb.append("}");

		return sb.toString();
	}

}
