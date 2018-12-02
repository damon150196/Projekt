package application;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;


public class Console extends Application 
{
    BorderPane root = new BorderPane();
	Scene scene = new Scene(root,600,400);
	TextArea sourceCode = new TextArea();
	
	@Override
	public void start(Stage primaryStage) 
	{
	    root.getStyleClass().add("color-gray");
	    root.setPadding(new Insets(10,5,5,5));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		sourceCode.getStyleClass().add("console");
		sourceCode.setEditable(false);
		root.setCenter(sourceCode);
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}