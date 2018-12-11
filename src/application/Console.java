package application;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;


public class Console extends Application 
{	
	private BorderPane root = new BorderPane();
	private Scene scene = new Scene(root,600,400);
	private TextArea console = new TextArea();
	private File file;
	private StringBuilder textToConsole = new StringBuilder();
	
	public Console(File f)
	{
		file = f;
	}
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Projekt Kompetencyjny - Konsola");
		
	    root.getStyleClass().add("color-gray");
	    root.setPadding(new Insets(10,5,5,5));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		console.getStyleClass().add("console");
		console.setEditable(false);
		root.setCenter(console);
    	
		
		primaryStage.setScene(scene);
		primaryStage.show();
		

    	try 
    	{
        	ReadFile rf = new ReadFile(file);
        	
			while(rf.hasNextLine())
			{
				String line = rf.nextLine();
				
				/*
				 *   #####    ####   #####    ####   ######  #####
				 *   #    #  #    #  #    #  #       #       #    #
				 *   #    #  #    #  #    #   ####   ####    #    #
				 *   #####   ######  #####        #  #       #####
				 *   #       #    #  #  #    #    #  #       #  #
				 *   #       #    #  #   #    ####   ######  #   #
				 * 
				 */
				
				//testowo wyœwietlenie tekstu w oknie konsoli
				textToConsole.append(line);
			}
			
			console.setText(textToConsole.toString());
		} 
    	catch (FileNotFoundException e) 
    	{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód³ siê", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		} 
    	catch (IOException e) 
    	{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód³ siê", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	
	
	
}