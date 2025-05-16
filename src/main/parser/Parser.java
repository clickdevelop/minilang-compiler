package main.parser;

import main.lexer.Token;
import main.lexer.TokenType;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Statement parse() {
        if (match(TokenType.IDENTIFICADOR)) {
            Token token = previous();
            if (token.getLexema().equals("mostra")) {
                Token stringToken = consume(TokenType.STRING, "Esperado uma string após 'mostra'");
                return new PrintStatement(stringToken.getLexema());
            }
        }

        throw new RuntimeException("Comando inválido.");
    }

    // Helpers

    private boolean match(TokenType type) {
        if (check(type)) {
            advance();
            return true;
        }
        return false;
    }

    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().getTipo() == type;
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd() {
        return current >= tokens.size();
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Token consume(TokenType type, String message) {
        if (check(type)) return advance();
        throw new RuntimeException(message);
    }
}
