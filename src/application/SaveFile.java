package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class SaveFile extends Application 
{
	private static String str;
	private static String nameFile = "DATA.txt";
	private static File file;
 	
    public static void main(String[] args) 
    {
    	stringIn();
        Application.launch(args);
    }
    
    public static void stringIn()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Podaj ci¹g znaków, który chcesz zapisaæ: ");
		
		str = in.nextLine();
	}
	
	public static File getSave() {
		return file;
	}

	public static void setSave(File save) {
		SaveFile.file = save;
	}

	public static String getStr(){
		return str;
	}
	
	public static String getNameFile(){
		return nameFile;
	}
    
    @Override
    public void start(Stage stage) 
    {
        stage.setTitle("Save File");
 
        FileChooser fileChooser = new FileChooser();    
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Data ", "*.momg"));
        file = fileChooser.showSaveDialog(stage);
        
        if (file != null) 
        {
        	try 
			{
				FileWriter saveFW = new FileWriter(file.getPath(), true);		
				BufferedWriter out = new BufferedWriter(saveFW);
				
				out.newLine();
				out.write(str);
				out.close();
				
				System.out.println("Zapis przebieg³ pomyœlnie.");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				System.out.println("Nie znaleziono pliku.");
			} 
        }
    }
}