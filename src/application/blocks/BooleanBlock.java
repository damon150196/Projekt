package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class BooleanBlock extends Block 
{
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
                if (!(tvalue.getText().matches("1") || tvalue.getText().matches("0"))) 
                {
                    tvalue.setText("0");
                }
            }
        });
		close.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{

			@Override
			public void handle(ActionEvent event)
			{
				variables.remove(oldName);
				Node n = getParent();
				Block b;

				languageBox.getChildren().clear();

				for(int i=0; i <  ((VBox) n).getChildren().size(); i++)
				{
					if(((VBox) n).getChildren().get(i) instanceof Block)
					{
						b = (Block) ((VBox) n).getChildren().get(i);

						if(tmp.equals(b))
						{
							((VBox) n).getChildren().remove(i);
							((VBox) n).getChildren().remove(i);
						}
					}
				}
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
