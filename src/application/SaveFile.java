package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class SaveFile
{
	private File file;

	public SaveFile(File f)
	{
		file = f;
        if (file == null) chose();
	}
	
	public File getFile() 
	{
		return file;
	}
	public void setFile(File save) 
	{
		this.file = save;
	}
    
	
	
    private void chose() 
    {
    	Stage stage =new Stage();
        stage.setTitle("Save File");
 
        FileChooser fileChooser = new FileChooser();    
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Data ", "*.momg"));
        file = fileChooser.showSaveDialog(stage);
    }

    
    
	public void write(String str) throws IOException
	{
		FileWriter saveFW = new FileWriter(file.getPath(), false);		
		BufferedWriter out = new BufferedWriter(saveFW);
		
		out.flush();
		out.write(str);
		out.close();
	}
	
}