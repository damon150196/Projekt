package application;

import java.io.File;

import application.blocks.Block;
import application.blocks.BorderedTitledPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application 
{
    BorderPane root = new BorderPane();
	Scene scene = new Scene(root,1000,650);
	BorderPane top = new BorderPane();
	BorderedTitledPane left = new BorderedTitledPane("Sk³adnia jêzyka");
	BorderedTitledPane right = new BorderedTitledPane("Podgl¹d Kodu");
	boolean rightShowed = true;
	BorderedTitledPane content = new BorderedTitledPane("Obszar Roboczy");
	
	File file;
	Console console = new Console();
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
		    root.getStyleClass().add("color-gray");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//============================ TOP PANEL =====================================
			
			HBox top_r = new HBox(2);
			HBox top_l = new HBox(2);
			
			Button top_new = new Button("\uD83D\uDCC4");
			Button top_open = new Button("\uD83D\uDCC2");
			Button top_save = new Button("\uD83D\uDCBE");
			Button podglad = new Button("Podglad Kodu");
			
			top_new.getStyleClass().add("btn");
			top_open.getStyleClass().add("btn");
			top_save.getStyleClass().add("btn");
			podglad.setPrefSize(100, 50);
			podglad.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            
	            @Override
	            public void handle(ActionEvent event) 
	            {
	            	if(rightShowed==false)
	            	{
	            		root.setRight(right);
	            		rightShowed=true;
	            	}
	            	else
	            	{
	            		root.setRight(null);
	            		rightShowed=false;
	            	}
	            }
	        });		

			Button consolButton = new Button("Konsola");
			consolButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
			{
	            @Override
	            public void handle(ActionEvent event) 
	            {
	            	Stage consoleStage = new Stage(); 
	            	console.start(consoleStage);
	            	console.readFile(file);
	            }
	        });		

			top_l.getChildren().add(top_new);
			top_l.getChildren().add(top_open);
			top_l.getChildren().add(top_save);
			top_r.getChildren().add(podglad);

			top.setLeft(top_l);
			top.setRight(top_r);
			top.setCenter(consolButton);
			root.setTop(top);
			
			


			//============================ LEFT PANEL =====================================
			left.setPrefSize(200, 600);

			root.setLeft(left);
			
			//============================ CONTENT PANEL =====================================
			content.setPrefHeight(600);

			VBox content2 = new VBox();
			
			Block main = new Block("Main");
			StackPane content22 = new StackPane();
			content2.getChildren().add(main);
			content2.getChildren().add(content22);
			
			content.getChildren().add(content2);
			
			root.setCenter(content);

			//============================ RIGHT PANEL =====================================
			right.setPrefSize(300, 600);
			
			TextArea sourceCode = new TextArea();
			sourceCode.setEditable(false);
			sourceCode.getStyleClass().add("console");
			
			right.getChildren().add(sourceCode);
			
			root.setRight(right);
			
			
		    
			//=============================================================================
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}