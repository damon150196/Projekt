package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class SaveFile extends Application 
{
	private String str;
	private File file;
    
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
			} 
			catch (IOException e) 
			{
				//e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR, "Zapis nie powiód³ siê", ButtonType.OK);
				alert.setTitle("Error");
				alert.showAndWait();
			} 
        }
    }
    
	
	
	
	public File getSave() {
		return file;
	}

	public void setSave(File save) {
		this.file = save;
	}

	public String getStr(){
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
}