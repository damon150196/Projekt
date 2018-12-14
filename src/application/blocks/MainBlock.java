package application.blocks;

import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MainBlock extends Block
{
	List<String> listButtonsNames;
	int defaultVariableNumber;

	public MainBlock(VBox languageBox)
	{
		super(languageBox);
		listButtonsNames = new ArrayList<>();
		defaultVariableNumber = 0;
		this.setBackgroundColor("#EAEAEA");
		this.setBlockName("Main");

		close.setVisible(false);

		vb.getChildren().add(new ButtonBlock("+", vb, lb, 0, listButtonsNames, defaultVariableNumber));

		content.setBottom(vb);
	}

	public void clear()
	{
		vb.getChildren().clear();
		vb.getChildren().add(new ButtonBlock("+", vb, lb, 0,listButtonsNames, defaultVariableNumber));
	}
	public boolean isEmpty()
	{
		if(vb.getChildren().size() == 1) return true;

		return false;
	}

	@Override
	public String getFunctionString(int tabCount)
	{
		StringBuilder sb = new StringBuilder("Main()\n{\n");

		for(int i=0; i <  vb.getChildren().size(); i++)
		{
			if( vb.getChildren().get(i) instanceof Block)
			{
				sb.append(tabs(tabCount+1));
				Block b = (Block) vb.getChildren().get(i);
				sb.append(b.getFunctionString(tabCount+1) + "\n");
			}
		}
		sb.append("}");

		return sb.toString();
	}

	@Override
	public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {

	}

}