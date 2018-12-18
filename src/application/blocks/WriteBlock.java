package application.blocks;


import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WriteBlock extends Block
{
	public WriteBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		tvalue.setPrefWidth(400);
		this.setBackgroundColor("#BFA76F");
		this.setBlockName("Write");
		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tvalue.setPromptText("Wyœwietl: ");

		hb.getChildren().add(tvalue);
		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
		if(variables.contains(tvalue.getText()))
		{
			return "write (" + tvalue.getText() + ");";
		}
		return "write (\"" + tvalue.getText() + "\");";
	}

}
