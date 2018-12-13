package application;


import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;
import application.interpreter.parser.Parser;
import application.interpreter.exceptions.NotParsed;
import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownOperator;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Console extends Application {
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root, 600, 400);
    private TextArea console = new TextArea();
    private File file;
    private StringBuilder textToConsole = new StringBuilder();

    public Console(File f) {
        file = f;
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Projekt Kompetencyjny - Konsola");

        root.getStyleClass().add("color-gray");
        root.setPadding(new Insets(10, 5, 5, 5));
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


        console.getStyleClass().add("console");
        console.setEditable(false);
        root.setCenter(console);


        primaryStage.setScene(scene);
        primaryStage.show();


        try {
            HashMap<String, Value> map = new HashMap<>();
            Program p = null;
            String linia = "";
            String ostatniaLinia = "";

            //File file = new File(file);
            Scanner sc = new Scanner(file);

            sc.nextLine();
            sc.nextLine();

            while (sc.hasNext()) {

                ostatniaLinia = sc.nextLine();
                linia = linia + ostatniaLinia;

                System.out.println(linia);
            }

            linia = linia.replace(";", "");
            linia = linia.replace(ostatniaLinia, "");
            linia = linia.replace("int", "");
            linia = linia.replace("String", "");


            linia = linia + ";";
            String s = "p = 100 b = 100 write p;";


            System.out.println(linia);


            Parser parser = new Parser(linia);

            try {
                p = parser.parseProgram();
            } catch (NotParsed notParsed) {
                notParsed.printStackTrace();
            } catch (UnknownType unknownType) {
                unknownType.printStackTrace();
            }

            try {
                p.eval(map, console);
            } catch (UnknownOperator unknownOperator) {
                unknownOperator.printStackTrace();
            } catch (VariableNotFound variableNotFound) {
                variableNotFound.printStackTrace();
            } catch (IncompatibilityTypes incompatibilityTypes) {
                incompatibilityTypes.printStackTrace();
            } catch (UnknownType unknownType) {
                unknownType.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód? si?", ButtonType.OK);
            alert2.setTitle("Error");
            alert2.showAndWait();
        } catch (IOException e) {
            Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód? si?", ButtonType.OK);
            alert2.setTitle("Error");
            alert2.showAndWait();
        }


    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


<<<<<<< HEAD
public class Console extends Application 
{	
	private BorderPane root = new BorderPane();
	private Scene scene = new Scene(root,600,400);
	private TextArea console = new TextArea();
	private File file;
	private StringBuilder textToConsole = new StringBuilder();
	
	public Console(File f)
	{
		file = f;
	}
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		primaryStage.setTitle("Projekt Kompetencyjny - Konsola");
		
	    root.getStyleClass().add("color-gray");
	    root.setPadding(new Insets(10,5,5,5));
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		console.getStyleClass().add("console");
		console.setEditable(false);
		root.setCenter(console);
    	
		
		primaryStage.setScene(scene);
		primaryStage.show();
		

    	try 
    	{
        	ReadFile rf = new ReadFile(file);
        	
        	textToConsole.append(rf.read());
        	
        	/*
			while(rf.hasNextLine())
			{
				String line = rf.nextLine();
				
				
				 *   #####    ####   #####    ####   ######  #####
				 *   #    #  #    #  #    #  #       #       #    #
				 *   #    #  #    #  #    #   ####   ####    #    #
				 *   #####   ######  #####        #  #       #####
				 *   #       #    #  #  #    #    #  #       #  #
				 *   #       #    #  #   #    ####   ######  #   #
				 * 
				 
				
				//testowo wyœwietlenie tekstu w oknie konsoli
				textToConsole.append(line);
			}
			*/
			console.setText(textToConsole.toString());
		} 
    	catch (FileNotFoundException e) 
    	{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód³ siê", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		} 
    	catch (IOException e) 
    	{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód³ siê", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	
	
	
=======
>>>>>>> development
}