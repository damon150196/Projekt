package application.blocks.condition;

import java.util.ArrayList;

import application.blocks.Block;
import application.blocks.ButtonBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GreaterBlock extends Block 
{
	public GreaterBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		GreaterBlock tmp = this;
		this.setBackgroundColor("#808080");
		this.setBlockName(">");

		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tleft.setPromptText("Lewa strona: ");
		tright.setPromptText("Prawa strona: ");

		hb.getChildren().add(tleft);
		hb.getChildren().add(new Label(name.getText()));
		hb.getChildren().add(tright);

		vb.getChildren().add(hb);
		

		close.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            
            @Override
            public void handle(ActionEvent event) 
            {
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
                            ((VBox) n).getChildren().add(i, new ButtonBlock(" + ", ((VBox) n), lb, 0, variables));
                            ((VBox) n).getChildren().remove(i+1);
                		}
            		}
            	}
            }
        });	
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
		return tleft.getText() + ">" + tright.getText();
	}


}
