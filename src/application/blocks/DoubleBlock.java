package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DoubleBlock extends Block
{
	private TextField tname = new TextField();
	private TextField tvalue = new TextField();
	
	public DoubleBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#6B54FF");
		this.setBlockName("Double");

		
		HBox hb= new HBox();
		hb.setSpacing(10);
		
		tname.setPromptText("Nazwa: ");
		tvalue.setPromptText("Warto��: ");
		
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
			            if(tvalue.getText().matches("^[a-zA-Z]*$"))
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
	public String getFunctionString() 
	{
		if(tvalue.getText() == "")
		{
			return "double " + tname.getText() + ";";
		}
		else
		{
			return "double " + tname.getText() + " = " + tvalue.getText() + ";";
		}
	}

}