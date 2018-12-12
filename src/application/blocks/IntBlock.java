package application.blocks;


import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class IntBlock extends Block
{
	private TextField tname = new TextField();
	private TextField tvalue = new TextField();
	
	public IntBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#FE5A1D");
		this.setBlockName("Int");

		
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
			            if(!tvalue.getText().matches("^[0-9]*$"))
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
		if(tvalue.getText().isEmpty())
		{
			return "int " + tname.getText() + ";";
		}
		else
		{
			return "int " + tname.getText() + " = " + tvalue.getText() + ";";
		}
	}

}
