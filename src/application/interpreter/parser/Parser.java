package application.interpreter.parser;

import application.interpreter.exceptions.*;
import application.interpreter.expression.*;

import application.interpreter.instruction.program.Program;
import application.interpreter.parser.expression.ParserExpression;
import application.interpreter.parser.program.ParserProgram;


public class Parser {

    private String input;
    private Integer[] position;

    private ParserExpression parserExpression;
    private ParserProgram parserProgram;

    public Parser(String input) {
        this.input = input;
        this.position = new Integer[1];
        this.position[0] = 0;
        this.parserExpression = new ParserExpression(this.input, this.position);
        this.parserProgram = new ParserProgram(this.input, this.position);
    }

    public Expression parseExpression() throws NotParsed, UnknownType {
        return parserExpression.parseExpression();
    }

    public Program parseProgram() throws NotParsed, UnknownType {
        return parserProgram.parseProgram();
    }
}
