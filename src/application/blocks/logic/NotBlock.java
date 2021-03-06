package application.blocks.logic;

import java.util.ArrayList;

import application.blocks.Block;
import application.blocks.ButtonBlock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class NotBlock extends Block {

	public NotBlock(VBox languageBox, ArrayList<String> var) 
    {
        super(languageBox, var);
		NotBlock tmp = this;
        this.setBackgroundColor("#808080");
        this.setBlockName("!");


        vb.getChildren().add(new Label(name.getText()));
        vb.getChildren().add(new ButtonBlock(" + ", vb, lb, 0, variables));



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
                            ((VBox) n).getChildren().add(i, new ButtonBlock(" + ", ((VBox) n), lb, 0, variables));
                            ((VBox) n).getChildren().remove(i+1);
                            
                        }
                    }
                }
            }
        });
        
        
	}

	@Override
	public String getFunctionString(int tabCount) 
	{
        StringBuilder sb = new StringBuilder("! (");

        if( vb.getChildren().get(1) instanceof Block)
        {
            Block b = (Block) vb.getChildren().get(1);
            sb.append(b.getFunctionString(1));
        }

        sb.append(")");
        return sb.toString();
	}


}
