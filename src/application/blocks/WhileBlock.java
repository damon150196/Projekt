package application.blocks;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class WhileBlock extends Block {

    public WhileBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#4080FF");
        this.setBlockName("While");
        this.setPadding(new Insets(5,0,5,0));


        vb.getChildren().add(new WhileConditionBlock(lb, variables));
        vb.getChildren().add(new WhileTrueBlock(lb, variables));

        content.setBottom(vb);
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder("while( ");

        if( vb.getChildren().get(0) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(0);
            sb.append(b.getFunctionString(0));
        }

        sb.append(" )\n");
        sb.append(tabs(tabCount));
        sb.append("{\n");

        if( vb.getChildren().get(1) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(1);
            sb.append(b.getFunctionString(tabCount+1));
        }
        sb.append(tabs(tabCount));
        sb.append("}\n");



        return sb.toString();
    }
}