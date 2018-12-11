package application.blocks;


import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class IfBlock extends Block 
{

	public IfBlock(VBox languageBox) 
	{
		super(languageBox);
		this.setBackgroundColor("#80FF40");
		this.setBlockName("If");
		this.setPadding(new Insets(5,0,5,0));


		vb.getChildren().add(new IfConditionBlock(lb));	
		vb.getChildren().add(new IfTrueBlock(lb));	
		vb.getChildren().add(new ButtonBlock("+ ", vb, lb, 0));	

		content.setBottom(vb);
	}

	@Override
	public String getFunctionString() 
	{
		return null;
	}

}
