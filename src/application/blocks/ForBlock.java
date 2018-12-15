package application.blocks;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ForBlock extends Block {

    public ForBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#80ADCD");
        this.setBlockName("For");
        this.setPadding(new Insets(5,0,5,0));


        vb.getChildren().add(new IntBlock(lb, variables));
        vb.getChildren().add(new ForConditionBlock(lb, variables));
        vb.getChildren().add(new OperationBlock(lb, variables));
        vb.getChildren().add(new ForTrueBlock(lb, variables));

        content.setBottom(vb);
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder("for(");

        if( vb.getChildren().get(0) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(0);
            sb.append(b.getFunctionString(0));
        }
        if( vb.getChildren().get(1) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(1);
            sb.append(b.getFunctionString(1));
        }
        sb.append(";");
        if( vb.getChildren().get(2) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(2);
            sb.append(b.getFunctionString(2));
        }

        sb.append(")\n");
        sb.append(tabs(tabCount));
        sb.append("{\n");

        if( vb.getChildren().get(3) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(3);
            sb.append(b.getFunctionString(tabCount+1));
        }
        sb.append(tabs(tabCount));
        sb.append("}\n");



        return sb.toString();
    }


}