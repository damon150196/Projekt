package application;


import application.interpreter.exceptions.*;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;
import application.interpreter.parser.Parser;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;


public class Console extends Application 
{
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root, 600, 400);
    private TextArea console = new TextArea();
    private File file;
    private StringBuilder textToConsole = new StringBuilder();
    
    public Console(File f) {
        file = f;
    }


    @SuppressWarnings({ "hiding", "resource" })
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


            }

            System.out.println(linia);

            linia = linia.replace(";", "");
            //linia = linia.replace(ostatniaLinia, "");
            linia = linia.replace("int ", "");
            linia = linia.replace("double ", "");
            linia = linia.replace("String ", "");
            linia = linia.replace("==", "=");
            linia = linia.replace("(", "");
            linia = linia.replace(")", "");

            linia = linia.substring(0, linia.length()-1);



            System.out.println("Efekt przed" + linia);
            linia = linia + ";";

            console.appendText("Rezultat wykonanego programu to: \n");

            System.out.println("Efekt" + linia);


            Parser parser = new Parser(linia);
            
            
            /*
             * Parser powinien zwraca� warto�ci (tekst) kt�re maj� by� wy�wietlnone w konsoli
             * 
             * Czyli najlepiej jak b�dzie tekst do wy�wietlenia dopisywany do zmiennej 
             * -> textToConsole
             * 
             * by mo�na u�y� -> console.setText(textToConsole.toString());
             * czyli wy�wietlenie efektu dzia�ania programu na konsoli 
             * 
             * 
             * funkcja read(String type) ma wbudowan� opcj� do wy�wietlania na konsoli obecnego stanu programu, kt�ry jest zawarty w textToConsole
             * 
             * funkcja read() wy�wietla p�ki co okienko gdzie podaje si� warto��, ale planowane jest zrobienie tego pod konsolk� programu
             * gdzie b�dzie pojawia�o si� TextField i Button do pobierania od u�ytkownika danych
             * 
             */

             p = parser.parseProgram();
             p.eval(map, console);

        } 
        catch (NotParsed notParsed) 
        {
            notParsed.printStackTrace();
        } 
        catch (UnknownType unknownType) 
        {
            unknownType.printStackTrace();
        } 
        catch (UnknownOperator unknownOperator) 
        {
            unknownOperator.printStackTrace();
        } 
        catch (UnauthorizedOperation unknownOperator) 
        {
            unknownOperator.printStackTrace();
        } 
        catch (VariableNotFound variableNotFound) 
        {
            variableNotFound.printStackTrace();
        } 
        catch (IncompatibilityTypes incompatibilityTypes) 
        {
            incompatibilityTypes.printStackTrace();
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String read(String type) 
    {
    	String value = new String();
    	console.setText(textToConsole.toString());
        TextInputDialog dialog = new TextInputDialog();
 
        dialog.setTitle("Read");
        dialog.setHeaderText("Read " + type +":");
        dialog.setContentText("read:");
 
        Optional<String> result = dialog.showAndWait();
        value = result.get();
        
        // tu doda� warunki odno�nie typ�w jakie warto�ci powinna ta funkcja zwraca� 
        
        return value;
    }

}