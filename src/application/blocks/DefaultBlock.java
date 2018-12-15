
package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public class DefaultBlock extends Block
{
    public DefaultBlock(VBox languageBox, List<String> listButtonsNames, int defaultVariableNumber)
    {
        super(languageBox);
        DefaultBlock tmp = this;
        this.setBackgroundColor("#AEDC99");
        this.setBlockName("Default");

        vb.getChildren().add(new ButtonBlock("+", vb, lb, 0, listButtonsNames, defaultVariableNumber));

        content.setBottom(vb);

        close.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                Node n = getParent();
                Block b;

                languageBox.getChildren().clear();

                for(int i=0; i <  ((VBox) n).getChildren().size(); i++)
                {
                    if(((VBox) n).getChildren().get(i) instanceof Block)
                    {
                        b = (Block) ((VBox) n).getChildren().get(i);

                        if(tmp.equals(b))
                        {
                            ((VBox) n).getChildren().remove(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    public String getFunctionString(int tabCount)
    {
        StringBuilder sb = new StringBuilder("Default: \n");

        for(int i=0; i <  vb.getChildren().size(); i++)
        {
            if( vb.getChildren().get(i) instanceof Block)
            {
                sb.append(tabs(tabCount));
                Block b = (Block) vb.getChildren().get(i);
                sb.append(b.getFunctionString(tabCount+1) + "\n");
            }
        }

        sb.append(tabs(tabCount));
        sb.append("break;\n");
        return sb.toString();
    }

    @Override
    public void checkVariableName(String variableName, List<String> listButtonsNames, int defaultVariableNumber) {

    }

}
