package application;


import application.interpreter.exceptions.*;
import application.interpreter.expression.Value;
import application.interpreter.instruction.program.Program;
import application.interpreter.parser.Parser;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Console extends Application 
{
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root, 600, 400);
    private TextArea console = new TextArea();
    private File file;
    
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
//            linia = linia.replace("(", "");
//            linia = linia.replace(")", "");

            linia = linia.substring(0, linia.length()-1);



            System.out.println("Efekt przed" + linia);
            linia = linia + ";";

            console.appendText("Rezultat wykonanego programu to: \n");

            System.out.println("Efekt" + linia);


            Parser parser = new Parser(linia);
            
            
            /*
             * Parser powinien zwracaæ wartoœci (tekst) które maj¹ byæ wyœwietlnone w konsoli
             * 
             * Czyli najlepiej jak bêdzie tekst do wyœwietlenia dopisywany do zmiennej 
             * -> textToConsole
             * 
             * by mo¿na u¿yæ -> console.setText(textToConsole.toString());
             * czyli wyœwietlenie efektu dzia³ania programu na konsoli 
             * 
             * 
             * funkcja read(String type) ma wbudowan¹ opcjê do wyœwietlania na konsoli obecnego stanu programu, który jest zawarty w textToConsole
             * 
             * funkcja read() wyœwietla póki co okienko gdzie podaje siê wartoœæ, ale planowane jest zrobienie tego pod konsolk¹ programu
             * gdzie bêdzie pojawia³o siê TextField i Button do pobierania od u¿ytkownika danych
             * 
             */

             p = parser.parseProgram();
             p.eval(map, console);

        } 
        catch (NotParsed e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (UnknownType e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (UnknownOperator e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (UnauthorizedOperation e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (VariableNotFound e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (IncompatibilityTypes e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        }
        catch (FileNotFoundException e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            console.getStyleClass().add("console-error");
            console.setText(e.getMessage());
            e.printStackTrace();
        }
        
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}