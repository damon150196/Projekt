package application.blocks;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class BorderedTitledPane extends StackPane
{
	public BorderedTitledPane(String titleString) 
	{
		this.getStyleClass().add("titled-address");
		
		Label title = new Label(" " + titleString + " ");
		title.getStyleClass().add("bordered-titled-title");
		StackPane.setAlignment(title, Pos.TOP_LEFT);
		
		getStyleClass().add("bordered-titled-border");
		this.getChildren().addAll(title);
	  
	};
}