package application.blocks;

import application.blocks.condition.*;
import application.blocks.logic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.List;

public class ButtonBlock extends Button
{

	public ButtonBlock(String arg0, VBox t, VBox o, int pos, List<String> listButtonsNames, int defaultVariableNumber)
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
				this.setStyle("-fx-background-color: #FF8040;");
				break;
			case "String":
				this.setStyle("-fx-background-color: #DC219E;");
				break;
			case "Double":
				this.setStyle("-fx-background-color: #6B54FF;");
				break;
			case "Boolean":
				this.setStyle("-fx-background-color: #21DC59;");
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
			case "!=":
			case "<":
			case ">":
			case "<=":
			case ">=":
			case "!":
			case "||":
			case "&&":
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
								o.getChildren().add(new ButtonBlock("Int", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("String", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("Double", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("Boolean", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("Wykonaj", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("If", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("While", t, o, i, listButtonsNames, defaultVariableNumber));
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
								o.getChildren().add(new ButtonBlock("Else", t, o, i, listButtonsNames, defaultVariableNumber));
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
								o.getChildren().add(new ButtonBlock("==", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("!=", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("<", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock(">", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("<=", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock(">=", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("!", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("&&", t, o, i, listButtonsNames, defaultVariableNumber));
								o.getChildren().add(new ButtonBlock("||", t, o, i, listButtonsNames, defaultVariableNumber));
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
					t.getChildren().add(pos+1, new ElseBlock(o, listButtonsNames, defaultVariableNumber));
					t.getChildren().remove(pos);
					o.getChildren().clear();
				}
			});
		}
		else if(arg0 == "==" || arg0 == "!=" || arg0 == "<" || arg0 == ">" || arg0 == "<=" || arg0 == ">=" || arg0 == "!" || arg0 == "&&" || arg0 == "||")
		{
			setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
			{

				@Override
				public void handle(ActionEvent event)
				{
					switch(arg0)
					{
						case "==": t.getChildren().add(pos+1, new EqualsBlock(o, listButtonsNames, defaultVariableNumber));  break;
						case "!=": t.getChildren().add(pos+1, new NotEqualsBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "<": t.getChildren().add(pos+1, new LessBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case ">": t.getChildren().add(pos+1, new GreaterBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "<=": t.getChildren().add(pos+1, new LessEqualsBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case ">=": t.getChildren().add(pos+1, new GreaterEqualsBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "!": t.getChildren().add(pos+1, new NotBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "&&": t.getChildren().add(pos+1, new AndBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "||": t.getChildren().add(pos+1, new OrBlock(o, listButtonsNames, defaultVariableNumber)); break;
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
						case "Int": t.getChildren().add(pos+1, new IntBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "String": t.getChildren().add(pos+1, new StringBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "Double": t.getChildren().add(pos+1, new DoubleBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "Boolean": t.getChildren().add(pos+1, new BooleanBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "If": t.getChildren().add(pos+1, new IfBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "Else": t.getChildren().add(pos+1, new ElseBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "Wykonaj": t.getChildren().add(pos+1, new OperationBlock(o, listButtonsNames, defaultVariableNumber)); break;
						case "While": t.getChildren().add(pos+1, new WhileBlock(o, listButtonsNames, defaultVariableNumber)); break;
					}

					t.getChildren().add(pos+2, new ButtonBlock("+", t, o, pos+2, listButtonsNames, defaultVariableNumber));
					o.getChildren().clear();
				}
			});
		}
	}

}