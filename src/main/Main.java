package main;

import main.lexer.Lexer;
import main.lexer.Token;
import main.parser.Parser;
import main.parser.Statement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String codigo = "mostra \"Olá Mundo\"";

        Lexer lexer = new Lexer(codigo);
        List<Token> tokens = lexer.tokenize();

        Parser parser = new Parser(tokens);
        Statement stmt = parser.parse();

        stmt.execute();
    }
}
