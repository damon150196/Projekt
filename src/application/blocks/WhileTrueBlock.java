package application.blocks;

import javafx.scene.layout.VBox;

import java.util.List;

public class WhileTrueBlock extends Block
{

    public WhileTrueBlock(VBox languageBox, List<String> listButtonsNames, int defaultVariableNumber)
    {
        super(languageBox);
        this.setBackgroundColor("#5070DD");
        this.setBlockName("While (True)");

        close.setVisible(false);

        vb.getChildren().add(new ButtonBlock("+", vb, lb, 0, listButtonsNames, defaultVariableNumber));

        content.setBottom(vb);
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i <  vb.getChildren().size(); i++)
        {
            if( vb.getChildren().get(i) instanceof Block)
            {
                sb.append(tabs(tabCount));
                Block b = (Block) vb.getChildren().get(i);
                sb.append(b.getFunctionString(tabCount+1) + "\n");
            }
        }

        return sb.toString();
    }

    @Override
    public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {

    }

}
