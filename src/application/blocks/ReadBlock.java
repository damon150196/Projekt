package application.blocks;


import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ReadBlock extends Block
{
	public ReadBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		tvalue.setPrefWidth(400);
		this.setBackgroundColor("#BFA76F");
		this.setBlockName("Read");
		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tname.setPromptText("Zmienna: ");

		hb.getChildren().add(tname);
		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
			return "read " + tname.getText() + ";";
	}


}
