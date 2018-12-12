package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PrintBlock extends Block
{
	private TextField tvalue = new TextField();
	
	public PrintBlock(VBox languageBox) 
	{
		super(languageBox);
		tvalue.setPrefWidth(400);
		this.setBackgroundColor("#BFA76F");
		this.setBlockName("Print");
		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tvalue.setPromptText("Wyœwietl: ");

		hb.getChildren().add(tvalue);
		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString() 
	{
			return "System.out.println(\"" + tvalue.getText() + "\");";
	}

}
