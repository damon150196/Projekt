package application.blocks;

import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class IfConditionBlock extends Block
{

    public IfConditionBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#90FF40");
        this.setBlockName("Warunek");

        close.setVisible(false);

        vb.getChildren().add(new ButtonBlock(" + ", vb, lb, 0, variables));
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
