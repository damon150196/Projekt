package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public abstract class Block extends ScrollPane
{

	protected Label name = new Label();
	protected Button close = new Button("X");
	protected String color;
	protected BorderPane content = new BorderPane();
	protected VBox vb = new VBox();
	protected VBox lb = new VBox();
	protected ArrayList<String> variables;
	

	protected TextField tname = new TextField();
	protected TextField tvalue = new TextField();
	protected TextField tleft = new TextField();
	protected TextField tright = new TextField();
	protected String oldName = null;

	public Block(VBox languageBox, ArrayList<String> var)
	{
		Block tmp = this;
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.getStyleClass().add("block");
		this.setFitToWidth(true);
		lb = languageBox;
		variables = var;


		this.setBackgroundColor("#408000");
		this.setBlockName("Block");

		content.getStyleClass().add("block-content");

		close.getStyleClass().add("block-close-button");

		content.setLeft(name);
		content.setRight(close);
		content.setBottom(vb);
		this.setContent(content);



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
							((VBox) n).getChildren().remove(i);
						}
					}
				}
			}
		});
	}

	public void setBackgroundColor(String c)
	{
		color = c;
		this.setStyle("-fx-background: " +c+ ";");
	}
	public void setBlockName(String n)
	{
		name.setText(" " + n + " ");
		name.getStyleClass().add("block-title");
	}


	public abstract String getFunctionString(int tabCount);

	public String tabs(int tabs)
	{
		StringBuilder sb = new StringBuilder("");
		
		for(int j=0; j<tabs; j++)
		{
			sb.append("\t");
		}
		return sb.toString();
	}
	

	public String checkVariableName(String variableName) 
	{
		if(variables.contains(variableName))
		{
			int i=0;
			variableName = "var"+Integer.toString(i);
			while(variables.contains(variableName.toLowerCase()))
			{
				i++;
				variableName = "var"+Integer.toString(i);
			}
			variableName = "var"+Integer.toString(i);
		}
		variables.add(variableName);		
		return variableName;
	}

	public VBox getVb() 
	{
		return vb;
	}

	public VBox getLb() 
	{
		return lb;
	}
	
	public Block addBlock(String button)
	{
		int pos = vb.getChildren().size()-1;
		
		ButtonBlock bb = (ButtonBlock) vb.getChildren().get(pos);
		bb.fire();
		
		for(int i=0; i<lb.getChildren().size(); i++)
		{
			Node n = lb.getChildren().get(i);
			if(n instanceof ButtonBlock)
			{
				ButtonBlock nbb = (ButtonBlock) n;
				if(nbb.getName().equals(button))
				{
					nbb.fire();
				}
			}
		}
	
		
		return (Block) vb.getChildren().get(pos+1);
	}

	public Block addConditionBlock(String button, int pos)
	{
		ButtonBlock bb = (ButtonBlock) vb.getChildren().get(pos);
		bb.fire();
		
		for(int i=0; i<lb.getChildren().size(); i++)
		{
			Node n = lb.getChildren().get(i);
			if(n instanceof ButtonBlock)
			{
				ButtonBlock nbb = (ButtonBlock) n;
				if(nbb.getName().equals(button))
				{
					nbb.fire();
				}
			}
		}

		return (Block) vb.getChildren().get(pos);
	}
	public Block addLogicBlock(String button, int pos)
	{		
		ButtonBlock bb = (ButtonBlock) vb.getChildren().get(pos);
		bb.fire();
		
		for(int i=0; i<lb.getChildren().size(); i++)
		{
			Node n = lb.getChildren().get(i);
			if(n instanceof ButtonBlock)
			{
				ButtonBlock nbb = (ButtonBlock) n;
				if(nbb.getName().equals(button))
				{
					nbb.fire();
				}
			}
		}

		return (Block) vb.getChildren().get(pos);
	}
	public Block addElseBlock(String button)
	{
		ButtonBlock bb = (ButtonBlock) vb.getChildren().get(2);
		bb.fire();

		ButtonBlock nbb = (ButtonBlock)  lb.getChildren().get(0);
		nbb.fire();
		

		return (Block) vb.getChildren().get(2);
	}
	
	

	public void setTname(String name) 
	{
		tname.setText(checkVariableName(name));
		oldName = tname.getText();
	}
	public void setTnameNoCheck(String name) 
	{
		tname.setText(name);
	}

	public void setTvalue(String value)
	{
		tvalue.setText(value);
	}

	public void setTleft(String left)
	{
		tleft.setText(left);
	}

	public void setTright(String right)
	{
		tright.setText(right);
	}

	public void setVariables(ArrayList<String> variables) {
		this.variables = variables;
	}

	public String getName() {
		return name.getText();
	}

	public Button getClose() {
		return close;
	}

}
