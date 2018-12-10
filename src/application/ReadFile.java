package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadFile extends Application 
{
	private String str;
	private StringBuffer strB = new StringBuffer();
	private File file;
	
	public void start(Stage stage) 
    {
		stage.setTitle("Read File");
		
		FileChooser fileChooser = new FileChooser();   
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Data ", "*.momg"));
		file = fileChooser.showOpenDialog(stage);
		
		try 
		{
			@SuppressWarnings("resource")
			Scanner in = new Scanner(file);
		
			while(in.hasNextLine())
			{
				str = in.nextLine();
				strB.append(str + "\n");
			}
			
			displayFile();
		} 
		catch (FileNotFoundException e) 
		{
			//e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR, "Nie znaleziono pliku", ButtonType.OK);
			alert.setTitle("Error");
			alert.showAndWait();
		}	
    }
	
	public File getFile() {
		return file;
	}

	public void displayFile()
	{
		System.out.println(getStrFromFile());
	}
	
	public String getStrFromFile()
	{
		return strB.toString();
	}
}
