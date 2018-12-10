package application.blocks;

import javafx.scene.layout.VBox;

public class MainBlock extends Block
{
	
	public MainBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#EAEAEA");
		this.setBlockName("Main");
		
		close.setVisible(false);
		
		vb.getChildren().add(new ButtonBlock("+", vb, languageBox, 0));	

		content.setBottom(vb);
	}


	
	@Override
	public String getFunctionString() 
	{
    	StringBuilder sb = new StringBuilder("Main()\n{\n");
		
    	for(int i=0; i <  vb.getChildren().size(); i++)
    	{
    		if( vb.getChildren().get(i) instanceof Block)
    		{
        		Block b = (Block) vb.getChildren().get(i);
        		sb.append(b.getFunctionString() + "\n");
    		}
    	}
    	sb.append("} koniec");
    	
		return sb.toString();
	}

}
