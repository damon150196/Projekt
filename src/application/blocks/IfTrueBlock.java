package application.blocks;

import javafx.scene.layout.VBox;

public class IfTrueBlock extends Block 
{

	public IfTrueBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#70FF50");
		this.setBlockName("If (True)");
		
		close.setVisible(false);
	}

	@Override
	public String getFunctionString() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
