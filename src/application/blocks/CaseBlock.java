
package application.blocks;

import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CaseBlock extends Block
{
    public CaseBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        this.setBackgroundColor("#AE9990");
        this.setBlockName("Case");
        
        tvalue.setPromptText("Wartoœæ: ");

        tvalue.focusedProperty().addListener((arg0, oldValue, newValue) ->
        {
            if (!newValue) {
                if (tvalue.getText().matches("^[a-zA-Z]*$")) {
                    tvalue.setText("0");
                }


            }
        });


        vb.getChildren().add(tvalue);
        vb.getChildren().add(new ButtonBlock("+", vb, lb, 0, variables));

        content.setBottom(vb);

    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder("case " + tvalue.getText() + ": \n");

        for(int i=0; i <  vb.getChildren().size(); i++)
        {
            if( vb.getChildren().get(i) instanceof Block)
            {
                sb.append(tabs(tabCount+1));
                Block b = (Block) vb.getChildren().get(i);
                sb.append(b.getFunctionString(tabCount+1) + "\n");
            }
        }

        sb.append(tabs(tabCount));
        sb.append("break;\n");
        return sb.toString();
    }

}
