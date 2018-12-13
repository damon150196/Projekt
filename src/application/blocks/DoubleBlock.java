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
		this.setBackgroundColor("#71A6D2");
		this.setBlockName("Double");

		
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
			            if(tvalue.getText().matches("^[a-zA-Z]*$"))
			            {
			            	tvalue.setText("0.0");
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
		if(tvalue.getText().isEmpty())
		{
			return "double " + tname.getText() + ";";
		}
		else
		{
			return "double " + tname.getText() + " = " + tvalue.getText() + ";";
		}
	}

}
