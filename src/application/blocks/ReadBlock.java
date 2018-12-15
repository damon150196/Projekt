package application.blocks;


import java.util.ArrayList;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReadBlock extends Block
{
	private TextField tvalue = new TextField();
	
	public ReadBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		tvalue.setPrefWidth(400);
		this.setBackgroundColor("#BFA76F");
		this.setBlockName("Read");
		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tvalue.setPromptText("Typ zmiennej: ");

		hb.getChildren().add(tvalue);
		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
			return "read (" + tvalue.getText() + ");";
	}


}
