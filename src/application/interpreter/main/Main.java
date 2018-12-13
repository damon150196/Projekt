package application.interpreter.main;

import application.interpreter.exceptions.NotParsed;
import application.interpreter.exceptions.IncompatibilityTypes;
import application.interpreter.exceptions.UnknownType;
import application.interpreter.exceptions.VariableNotFound;
import application.interpreter.expression.*;
import application.interpreter.instruction.program.Program;
import application.interpreter.parser.Parser;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnknownType, VariableNotFound, IncompatibilityTypes, NotParsed, FileNotFoundException {

        HashMap<String, Value> map = new HashMap<>();
        String linia = "";
        String lastLine = "";

        File file =
                new File("C:\\Users\\Karol Oleksy\\Desktop\\karol.txt");
        Scanner sc = new Scanner(file);

        sc.nextLine();
        sc.nextLine();

        while (sc.hasNext()) {

            lastLine = sc.nextLine();
            linia = linia + lastLine;

            System.out.println(linia);
        }

        linia = linia.replace(";", "");
        linia = linia.replace(lastLine, "");
        linia = linia.replace("int", "");
        linia = linia.replace("String", "");


        linia = linia + ";";
        String s = "p = 100 b = 100 write p;";


        System.out.println(linia);


        Parser parser = new Parser(linia);
        Program p = parser.parseProgram();

       // p.eval(map);
    }


}
