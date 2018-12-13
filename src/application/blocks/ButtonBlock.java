package application.blocks;

import application.blocks.condition.*;
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
				this.setStyle("-fx-background-color: #DDDDDD;");// zwyk³y
				break;
			case "+ ": 
				this.setStyle("-fx-background-color: #DDDDDD;"); // od ELSE
				break;
			case " + ": 
				this.setStyle("-fx-background-color: #DDDDDD;"); // od warunków
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
			case "Print": 
				this.setStyle("-fx-background-color: #BFA76F;");
				break;
			case "Wykonaj": 
				this.setStyle("-fx-background-color: #EEEEEE;");
				break;
			case "If": 
				this.setStyle("-fx-background-color: #80FF40;");
				break;
			case "Else": 
				this.setStyle("-fx-background-color: #80FF40;");
				break;
			case "While": 
				this.setStyle("-fx-background-color: #4080FF;");
				break;
				

			case "==": 
				this.setStyle("-fx-background-color: #808080;");
				break;
			case "!=": 
				this.setStyle("-fx-background-color: #808080;");
				break;
			case "<": 
				this.setStyle("-fx-background-color: #808080;");
				break;
			case ">": 
				this.setStyle("-fx-background-color: #808080;");
				break;
			case "<=": 
				this.setStyle("-fx-background-color: #808080;");
				break;
			case ">=": 
				this.setStyle("-fx-background-color: #808080;");
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
<<<<<<< HEAD
	        	            	o.getChildren().add(new ButtonBlock("Print", t, o, i));
=======
	        	            	o.getChildren().add(new ButtonBlock("Wykonaj", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("If", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("While", t, o, i));
>>>>>>> Damian
	                		}
	            		}
	            	}
	            }
	        });
		}
		else if(arg0 == "+ ")
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
	        	            	o.getChildren().add(new ButtonBlock("Else", t, o, i));
	                		}
	            		}
	            	}
	            }
	        });
		}
		else if(arg0 == " + ")
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
	        	            	o.getChildren().add(new ButtonBlock("==", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("!=", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("<", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock(">", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock("<=", t, o, i));
	        	            	o.getChildren().add(new ButtonBlock(">=", t, o, i));
	                		}
	            		}
	            	}
	            }
	        });
		}
		else if(arg0 == "Else")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            
	            @Override
	            public void handle(ActionEvent event) 
	            {
	            	t.getChildren().add(pos+1, new ElseBlock(o)); 
            		t.getChildren().remove(pos);
	            	o.getChildren().clear();
	            }
	        });
		}
		else if(arg0 == "==" || arg0 == "!=" || arg0 == "<" || arg0 == ">" || arg0 == "<=" || arg0 == ">=")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            
	            @Override
	            public void handle(ActionEvent event) 
	            {
	        		switch(arg0)
	        		{
	        			case "==": t.getChildren().add(pos+1, new EqualsBlock(o));  break;
	        			case "!=": t.getChildren().add(pos+1, new NotEqualsBlock(o)); break;
	        			// pozmieniaæ Equalsblock na konkretne klasy 
	        			case "<": t.getChildren().add(pos+1, new EqualsBlock(o)); break;
	        			case ">": t.getChildren().add(pos+1, new EqualsBlock(o)); break;
	        			case "<=": t.getChildren().add(pos+1, new EqualsBlock(o)); break;
	        			case ">=": t.getChildren().add(pos+1, new EqualsBlock(o)); break;
	        		}

            		t.getChildren().remove(pos);
	            	o.getChildren().clear();
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
<<<<<<< HEAD
	        			case "Print": t.getChildren().add(pos+1, new PrintBlock(o)); break;
=======
	        			case "If": t.getChildren().add(pos+1, new IfBlock(o)); break;
	        			case "Else": t.getChildren().add(pos+1, new ElseBlock(o)); break;
	        			case "Wykonaj": t.getChildren().add(pos+1, new OperationBlock(o)); break;
	        			case "While": t.getChildren().add(pos+1, new WhileBlock(o)); break;
>>>>>>> Damian
	        		}
	            	
	            	t.getChildren().add(pos+2, new ButtonBlock("+", t, o, pos+2));
	            	o.getChildren().clear();
	            }
	        });
		}
	}

}
