package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadFile extends Application 
{
	private static String str;
	private static StringBuffer strB = new StringBuffer();
	private static File file;
	
	public static void main(String [] args)
	{
		Application.launch(args);		
	}
	
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
			e.printStackTrace();
			System.out.println("File not found!");
		}	
    }
	
	public static File getFile() {
		return file;
	}

	public static void displayFile()
	{
		System.out.println(getStrFromFile());
	}
	
	public static String getStrFromFile()
	{
		return strB.toString();
	}
}
