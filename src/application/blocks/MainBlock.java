package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class MainBlock extends Block
{

	VBox vb = new VBox();
	
	public MainBlock() 
	{
		super();
		this.setBackgroundColor("#EAEAEA");
		this.setBlockName("Main");

		
		content.setBottom(vb);
		
		close.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
		{
            
            @Override
            public void handle(ActionEvent event) 
            {
            	vb.getChildren().add(new IntBlock());
        		content.setBottom(vb);
            }
        });	
	}


	
	@Override
	public String getFunctionString() 
	{
    	StringBuilder sb = new StringBuilder("Main()\n{\n");
		
    	for(int i=0; i <  vb.getChildren().size(); i++)
    	{
    		Block b = (Block) vb.getChildren().get(i);
    		
    		sb.append(b.getFunctionString() + "\n");
    	}
    	sb.append("} koniec");
    	
		return sb.toString();
	}

}
