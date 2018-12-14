package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;


public abstract class Block extends ScrollPane
{

	protected Label name = new Label();
	protected Button close = new Button("X");
	protected String color;
	protected BorderPane content = new BorderPane();
	protected VBox vb = new VBox();
	protected VBox lb = new VBox();

	public Block(VBox languageBox)
	{
		Block tmp = this;
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.getStyleClass().add("block");
		this.setFitToWidth(true);
		lb = languageBox;



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

	public abstract void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber);

}