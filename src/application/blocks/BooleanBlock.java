package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BooleanBlock extends Block
{
	private TextField tname = new TextField();
	private TextField tvalue = new TextField();
	
	public BooleanBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#21DC59");
		this.setBlockName("Boolean");

		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tname.setPromptText("Nazwa: ");
		tvalue.setPromptText("Wartoœæ: ");
		
		tname.focusedProperty().addListener((arg0, oldValue, newValue) -> 
				{
			        if (!newValue) 
			        {
			            if(!tname.getText().matches("^[a-zA-Z][a-zA-Z0-9_]*$"))
			            {
			            	tname.setText("");
			            }
			        }
		
			    });
		
		tvalue.focusedProperty().addListener((arg0, oldValue, newValue) -> 
				{
			        if (!newValue) 
			        {
			            if(!(tvalue.getText().matches("true") || tvalue.getText().matches("false")))
			            {
			            	tvalue.setText("");
			            }
			        }
		
			    });

		hb.getChildren().add(tname);
		hb.getChildren().add(tvalue);

		vb.getChildren().add(hb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
		if(tvalue.getText() == "")
			return "boolean " + tname.getText() + ";";
		else
			return "boolean " + tname.getText() + " = " + tvalue.getText() + ";";
		
	}

}
