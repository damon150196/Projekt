
package application.blocks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ElseBlock extends Block
{

    public ElseBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
        ElseBlock tmp = this;
        this.setBackgroundColor("#80DD40");
        this.setBlockName("Else");


        vb.getChildren().add(new ButtonBlock("+", vb, lb, 0, variables));

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
                            ((VBox) n).getChildren().add(new ButtonBlock("+ ", ((VBox) n), lb, 0, variables));
                        }
                    }
                }
            }
        });
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

}
