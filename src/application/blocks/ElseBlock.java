package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ElseBlock extends Block 
{

	public ElseBlock(VBox languageBox) 
	{
		super(languageBox);
		ElseBlock tmp = this;
		this.setBackgroundColor("#80DD40");
		this.setBlockName("Else");
		
		

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
                			((VBox) n).getChildren().remove(i);
                			((VBox) n).getChildren().add(new ButtonBlock("+ ", ((VBox) n), lb, 0));	
                		}
            		}
            	}
            }
        });	
	}

	@Override
	public String getFunctionString() 
	{
		return null;
	}

}
