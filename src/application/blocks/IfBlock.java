package application.blocks;


import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class IfBlock extends Block
{

    public IfBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#80FF40");
        this.setBlockName("If");
        this.setPadding(new Insets(5,0,5,0));


        vb.getChildren().add(new IfConditionBlock(lb, variables));
        vb.getChildren().add(new IfTrueBlock(lb, variables));
        vb.getChildren().add(new ButtonBlock("+ ", vb, lb, 0, variables));

        content.setBottom(vb);
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder("if(");

        if( vb.getChildren().get(0) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(0);
            sb.append(b.getFunctionString(0));
        }

        sb.append(")\n");
        sb.append(tabs(tabCount));
        sb.append("{\n");

        if( vb.getChildren().get(1) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(1);
            sb.append(b.getFunctionString(tabCount+1));
        }
        sb.append(tabs(tabCount));
        sb.append("}\n");



        if( vb.getChildren().get(2) instanceof Block)
        {

            sb.append(tabs(tabCount));
            sb.append("else\n");

            sb.append(tabs(tabCount));
            sb.append("{\n");
            Block b = (Block) vb.getChildren().get(2);
            sb.append(b.getFunctionString(tabCount+1));
            sb.append(tabs(tabCount));
            sb.append("}");
        }
        else
        {

            sb.append(tabs(tabCount));
            sb.append("else\n");
            sb.append(tabs(tabCount));
            sb.append("{\n");
            sb.append(tabs(tabCount+1));
            sb.append("skip;\n");
            sb.append(tabs(tabCount));
            sb.append("}");
        }


        return sb.toString();
    }


}
