package application.blocks;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class Block extends ScrollPane
{

	public Block(String titleString)
	{
		BorderPane content = new BorderPane();
		Label name = new Label(" Block ");
		Button close = new Button("X");
		String color = "#80FF40";
		
		this.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		this.setStyle("-fx-background: " +color+ ";");
		this.getStyleClass().add("block");
		this.setFitToWidth(true);
		
		content.getStyleClass().add("block-content");
		
		name.getStyleClass().add("block-title");
		
		close.getStyleClass().add("block-close-button");
		
		content.setLeft(name);
		content.setRight(close);
		this.setContent(content);

	}
	
	public String getFunctionString()
	{
		String n="o";
		
		return n;
	}
	
}
