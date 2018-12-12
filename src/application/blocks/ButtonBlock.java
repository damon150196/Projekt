package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ButtonBlock extends Button 
{
	
	public ButtonBlock(String arg0, VBox t, VBox o, int pos) 
	{
		super(arg0);
		this.getStyleClass().add("buttonBlock");
		
		ButtonBlock tmp = this;
		
		switch(arg0)
		{
			case "+": 
				this.setStyle("-fx-background-color: #DDDDDD;");
				break;
				
			case "Int": 
				this.setStyle("-fx-background-color: #FE5A1D;");
				break;
			case "String": 
				this.setStyle("-fx-background-color: #FC5D5D;");
				break;
			case "Double": 
				this.setStyle("-fx-background-color: #71A6D2;");
				break;
			case "Boolean": 
				this.setStyle("-fx-background-color: #2e8b57;");
				break;
		}
		
		if(arg0 == "+")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            
	            @Override
	            public void handle(ActionEvent event) 
	            {
	            	Node n = getParent();
	            	ButtonBlock b;
	            	
	            	for(int i=0; i <  ((VBox) n).getChildren().size(); i++)
	            	{
	            		if(((VBox) n).getChildren().get(i) instanceof ButtonBlock)
	            		{
	            			b = (ButtonBlock) ((VBox) n).getChildren().get(i);
	                		
	                		if(tmp.equals(b))
	                		{
	        	            	
	        	            	o.getChildren().clear();
	        	            	o.getChildren().add(new ButtonBlock("Int", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("String", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("Double", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("Boolean", t, o, i));
	                		}
	            		}
	            	}
	            }
	        });
		}
		else
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            
	            @Override
	            public void handle(ActionEvent event) 
	            {
	        		switch(arg0)
	        		{
	        			case "Int": t.getChildren().add(pos+1, new IntBlock(o)); break;
	        			case "String": t.getChildren().add(pos+1, new StringBlock(o)); break;
	        			case "Double": t.getChildren().add(pos+1, new DoubleBlock(o)); break;
	        			case "Boolean": t.getChildren().add(pos+1, new BooleanBlock(o)); break;
	        		}
	            	
	            	t.getChildren().add(pos+2, new ButtonBlock("+", t, o, pos+2));
	            	o.getChildren().clear();
	            }
	        });
		}
	}

}
