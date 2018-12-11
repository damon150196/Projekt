package application.blocks;

import javafx.scene.layout.VBox;

public class IfConditionBlock extends Block 
{

	public IfConditionBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#90FF40");
		this.setBlockName("Tu bêd¹ bloki z warunkami");
		
		close.setVisible(false);
	}

	@Override
	public String getFunctionString() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
