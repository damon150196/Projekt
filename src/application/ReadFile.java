package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadFile
{
	private File file;
	private Scanner in;

	public ReadFile(File f) throws FileNotFoundException
	{
		file = f;
       //if (file == null)
        	chose();
        
		in = new Scanner(file);
	}
	
	public File getFile() 
	{
		return file;
	}
	public void setFile(File read) 
	{
		this.file = read;
	}
	
    private void chose() 
    {
    	Stage stage =new Stage();
    	stage.setTitle("Read File");
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Data ", "*.momg"));
		file = fileChooser.showOpenDialog(stage);
    }


	public String read() throws IOException
	{
		StringBuilder str = new StringBuilder();
		while(in.hasNextLine())
		{
			str.append(in.nextLine() + "\n");
		}
		
		return str.toString();
	}

	public String nextLine() throws IOException
	{
		StringBuilder str = new StringBuilder();
	
		if(in.hasNextLine())
		{
			str.append(in.nextLine() + "\n");
		}
		
		return str.toString();
	}

	public boolean hasNextLine() throws FileNotFoundException
	{
		return in.hasNextLine();
	}
}
