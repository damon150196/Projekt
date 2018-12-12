package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StringBlock extends Block
{
	private TextField tname = new TextField();
	private TextField tvalue = new TextField();
	
	public StringBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#DC219E");
		this.setBlockName("String");

		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tname.setPromptText("Nazwa: ");
		tvalue.setPromptText("Wartoœæ: ");
		
		tname.focusedProperty().addListener((arg0, oldValue, newValue) -> 
				{
			        if (!newValue) 
			            if(!tname.getText().matches("^[a-zA-Z][a-zA-Z0-9_]*$"))
			            	tname.setText("");
			    });

		hb.getChildren().add(tname);
		hb.getChildren().add(tvalue);

		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
    	if(tvalue.getText() == "")
			return "String " + tname.getText() + ";";
		else
			return "String " + tname.getText() + " = " + tvalue.getText() + ";";
		
	}

}
