package application.blocks;

import application.blocks.condition.*;
import application.blocks.logic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ButtonBlock extends Button
{
	private String name;
	
	public ButtonBlock(String arg0, VBox t, VBox o, int pos, ArrayList<String> var)
	{
		super(arg0);
		this.getStyleClass().add("buttonBlock");
		name = arg0;

		ArrayList<String> variables = var;
		ButtonBlock tmp = this;

		switch(arg0)
		{
			case "+":
				this.setStyle("-fx-background-color: #DDDDDD;");// zwykÂ³y
				break;
			case "+ ":
				this.setStyle("-fx-background-color: #DDDDDD;"); // od ELSE
				break;
			case " + ":
				this.setStyle("-fx-background-color: #DDDDDD;"); // od warunkÃ³w
				break;
			case "Int":
				this.setStyle("-fx-background-color: #FF8040;");
				break;
			case "String":
				this.setStyle("-fx-background-color: #DC219E;");
				break;
			case "Double":
				this.setStyle("-fx-background-color: #6B54FF;");
				break;
			//case "Boolean":
				//this.setStyle("-fx-background-color: #21DC59;");
				//break;
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
			//case "For":
				//this.setStyle("-fx-background-color: #80ADCD;");
				//break;
			case "Read":
				this.setStyle("-fx-background-color: #BFA76F;");
				break;
			case "Write":
				this.setStyle("-fx-background-color: #BFA76F;");
				break;


			case "=":
			//case "!=":
			case "<":
			case ">":
			//case "<=":
			//case ">=":
			//case "!":
			case "|":
			case "&":
			//case "Case":
			//case "Default":
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
								o.getChildren().add(new ButtonBlock("Int", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("String", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("Double", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("Boolean", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("Wykonaj", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("If", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("While", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("For", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("Switch", t, o, i, variables));
								//Wrazie co to zakomentowaæ te 2 poni¿ej 
								o.getChildren().add(new ButtonBlock("Read", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("Write", t, o, i, variables));
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
								o.getChildren().add(new ButtonBlock("Else", t, o, i, variables));
							}
						}
					}
				}
			});
		}
		/*
		else if(arg0 == " +  ")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event)
				{
					Node n = getParent();
					ButtonBlock b;
					int i=0;
					for(; i <  ((VBox) n).getChildren().size(); i++)
					{
						if(((VBox) n).getChildren().get(i) instanceof ButtonBlock)
						{
							b = (ButtonBlock) ((VBox) n).getChildren().get(i);

							if(tmp.equals(b))
							{

								o.getChildren().clear();
								o.getChildren().add(new ButtonBlock("Case", t, o, i, variables));
							}
						}
					}
					boolean addDefault = true;
					for(int j=0; j<t.getChildren().size(); j++)
					{
						if(t.getChildren().get(j) instanceof DefaultBlock)
						{
							addDefault = false;
						}
					}
					if(addDefault==true)
					{
						o.getChildren().add(new ButtonBlock("Default", t, o, i+1, variables));
					}
				}
			});
		}
		*/
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
								o.getChildren().add(new ButtonBlock("=", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("!=", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("<", t, o, i, variables));
								o.getChildren().add(new ButtonBlock(">", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("<=", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock(">=", t, o, i, variables));
								//o.getChildren().add(new ButtonBlock("!", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("&", t, o, i, variables));
								o.getChildren().add(new ButtonBlock("|", t, o, i, variables));
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
					t.getChildren().add(pos+1, new ElseBlock(o, variables));
					t.getChildren().remove(pos);
					o.getChildren().clear();
				}
			});
		}
		/*
		else if(arg0 == "Case")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event)
				{
					t.getChildren().add(pos+1, new CaseBlock(o, variables));
					t.getChildren().add(pos+2, new ButtonBlock(" +  ", t, o, pos+2, variables));
					o.getChildren().clear();
				}
			});
		}
		else if(arg0 == "Default")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event)
				{
					t.getChildren().add(t.getChildren().size(), new DefaultBlock(o, variables));
					o.getChildren().clear();
				}
			});
		}
		*/
		else if(arg0 == "=" || arg0 == "!=" || arg0 == "<" || arg0 == ">" || arg0 == "<=" || arg0 == ">=" || arg0 == "!" || arg0 == "&" || arg0 == "|")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event)
				{
					switch(arg0)
					{
						case "=": t.getChildren().add(pos+1, new EqualsBlock(o, variables));  break;
						//case "!=": t.getChildren().add(pos+1, new NotEqualsBlock(o, variables)); break;
						case "<": t.getChildren().add(pos+1, new LessBlock(o, variables)); break;
						case ">": t.getChildren().add(pos+1, new GreaterBlock(o, variables)); break;
						//case "<=": t.getChildren().add(pos+1, new LessEqualsBlock(o, variables)); break;
						//case ">=": t.getChildren().add(pos+1, new GreaterEqualsBlock(o, variables)); break;
						//case "!": t.getChildren().add(pos+1, new NotBlock(o, variables)); break;
						case "&": t.getChildren().add(pos+1, new AndBlock(o, variables)); break;
						case "|": t.getChildren().add(pos+1, new OrBlock(o, variables)); break;
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
						case "Int": t.getChildren().add(pos+1, new IntBlock(o, variables)); break;
						case "String": t.getChildren().add(pos+1, new StringBlock(o, variables)); break;
						case "Double": t.getChildren().add(pos+1, new DoubleBlock(o, variables)); break;
						//case "Boolean": t.getChildren().add(pos+1, new BooleanBlock(o, variables)); break;
						case "If": t.getChildren().add(pos+1, new IfBlock(o, variables)); break;
						case "Else": t.getChildren().add(pos+1, new ElseBlock(o, variables)); break;
						case "Wykonaj": t.getChildren().add(pos+1, new OperationBlock(o, variables)); break;
						case "While": t.getChildren().add(pos+1, new WhileBlock(o, variables)); break;
						//case "For": t.getChildren().add(pos+1, new ForBlock(o, variables)); break;
						//case "Switch": t.getChildren().add(pos+1, new SwitchBlock(o, variables)); break;
						case "Read": t.getChildren().add(pos+1, new ReadBlock(o, variables)); break;
						case "Write": t.getChildren().add(pos+1, new WriteBlock(o, variables)); break;
					}

					t.getChildren().add(pos+2, new ButtonBlock("+", t, o, pos+2, variables));
					o.getChildren().clear();
				}
			});
		}
	}

	public String getName() {
		return name;
	}

}