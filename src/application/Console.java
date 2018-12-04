package application;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class Console extends Application 
{
	private static String str;
	private static StringBuffer strB = new StringBuffer();
	
    BorderPane root = new BorderPane();
	Scene scene = new Scene(root,600,400);
	TextArea sourceCode = new TextArea();
	
	@Override
	public void start(Stage primaryStage) 
	{
	    root.getStyleClass().add("color-gray");
	    root.setPadding(new Insets(10,5,5,5));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		sourceCode.getStyleClass().add("console");
		sourceCode.setEditable(false);
		root.setCenter(sourceCode);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void readFile(File file)
	{
		//File file = new File(SaveFile.getNameFile());
		
		try 
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(file);
		
			while(in.hasNextLine())
			{
				str = in.nextLine();
				strB.append(str + "\n");
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("File not found!");
		}
		
	}
	
}