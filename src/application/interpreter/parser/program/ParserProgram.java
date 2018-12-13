package application.interpreter.parser.program;

import application.interpreter.exceptions.*;
import application.interpreter.expression.Expression;
import application.interpreter.instruction.complex.*;
import application.interpreter.instruction.program.Program;
import application.interpreter.instruction.simple.*;
import application.interpreter.parser.expression.ParserExpression;

public class ParserProgram {


    private String input;
    private Integer[] position;

    private ParserExpression parserExpression;

    private static final char END_OF_LINE = ';';

    public ParserProgram(String input, Integer[] position) {
        this.input = input;
        this.position = position;
        this.parserExpression = new ParserExpression(this.input,this.position);
    }


    public Program parseProgram() throws NotParsed, UnknownType {
        Program program = parseBlock();
        if(lookAhead() == END_OF_LINE)
            return program;
        else
            throw new NotParsed();
    }

    private String parseIdentifier(){
        StringBuilder template = new StringBuilder();
        while(Character.isDigit(input.charAt(position[0])) || Character.isAlphabetic(input.charAt(position[0]))){
            template.append(input.charAt(position[0]));
            position[0]++;
        }
        return template.toString();
    }

    private Program parseBlock() throws NotParsed, UnknownType {
        Program program = parseInstruction();
        char character = lookAhead();

        while(character != '}' && character!=END_OF_LINE){
            Program program1 = parseInstruction();
            program = new Composition(program,program1);
            character = lookAhead();
        }
        return program;
    }

    private Program parseInstruction() throws NotParsed, UnknownType {
        char character = lookAhead();
        if(character=='{'){
            position[0]++;
            Program program = parseBlock();
            if (lookAhead()=='}') {
                position[0]++;
                return program;
            }
            else {
                throw new NotParsed();
            }
        }
        else if(Character.isAlphabetic(character)) {
            String parseIdentifier = parseIdentifier();
            if (parseIdentifier == "read")
                return parseRead();
            else if (parseIdentifier.equals("write"))
                return parseWrite();
            else if (parseIdentifier.equals("if"))
                return parseIf();
            else if (parseIdentifier.equals("while"))
                return parseWhile();
            else if (parseIdentifier.equals("skip"))
                return new Skip();
            else
                return parseAssign(parseIdentifier);
        }
        else
            throw new NotParsed();
    }


    private Program parseRead() throws NotParsed {
        char character = lookAhead();
        if (Character.isAlphabetic(character)) {
            String parseIdentifier = parseIdentifier();
            return new Read(parseIdentifier);
        }
        else
            throw new NotParsed();
    }

    private Program parseWrite() throws NotParsed {
        char character = lookAhead();
        if (Character.isAlphabetic(character)) {
            String parseIdentifier = parseIdentifier();
            return new Write(parseIdentifier);
        }
        else
            throw new NotParsed();
    }

    private Program parseIf() throws NotParsed, UnknownType {
        Expression expression = parserExpression.parseSum();
        Program program = parseInstruction();
        if (Character.isAlphabetic(lookAhead())) {
            if(parseIdentifier().equals("else")) {
                Program program1 = parseInstruction();
                return new If(expression, program, program1);
            }
            else
                throw new NotParsed();
        }
        else
            throw new NotParsed();
    }



    private Program parseWhile() throws NotParsed, UnknownType {
        Expression expression = parserExpression.parseSum();
        Program program = parseInstruction();
        return new While(expression, program);
    }



    private Program parseAssign(String input) throws NotParsed, UnknownType {
        char character = lookAhead();
        if (character == '=')
        {
            position[0]++;
            Expression expression = parserExpression.parseSum();
            return new Assing(input, expression);
        }
        else
            throw new NotParsed();
    }

    private char lookAhead() {
        skipWhitespace();
        return input.charAt(position[0]);
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(input.charAt(position[0])))
            position[0]++;
    }
}
