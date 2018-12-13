package application.blocks;

import javafx.scene.layout.VBox;

public class WhileConditionBlock extends Block 
{

	public WhileConditionBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#3090FF");
		this.setBlockName("Warunek");
		
		close.setVisible(false);
		
		vb.getChildren().add(new ButtonBlock(" + ", vb, lb, 0));	
		content.setBottom(vb);
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
    	StringBuilder sb = new StringBuilder("");
    	
		if( vb.getChildren().get(0) instanceof Block)
		{
    		Block b = (Block) vb.getChildren().get(0);
    		sb.append(b.getFunctionString(0));
		}

		return sb.toString();
	}

}