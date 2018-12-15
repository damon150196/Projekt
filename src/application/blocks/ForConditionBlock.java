package application.blocks;

import javafx.scene.layout.VBox;

import java.util.List;

public class ForConditionBlock extends Block
{

    public ForConditionBlock(VBox languageBox, List<String> listButtonsNames, int defaultVariableNumber)
    {
        super(languageBox);
        this.setBackgroundColor("#90ADDC");
        this.setBlockName("Warunek");

        close.setVisible(false);

        vb.getChildren().add(new ButtonBlock(" + ", vb, lb, 0, listButtonsNames, defaultVariableNumber));
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

    @Override
    public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {

    }

}
