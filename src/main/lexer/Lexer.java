package main.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String source;
    private int current = 0;
    private List<Token> tokens = new ArrayList<>();

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> tokenize() {
        while (!isAtEnd()) {
            char c = advance();

            switch (c) {
                case ' ':
                case '\r':
                case '\t':
                case '\n':
                    break; // ignorar espaços
                case '"':
                    tokens.add(string());
                    break;
                default:
                    if (isAlpha(c)) {
                        tokens.add(identifier(c));
                    } else {
                        throw new RuntimeException("Caractere inesperado: " + c);
                    }
            }
        }

        return tokens;
    }

    private Token identifier(char first) {
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        while (!isAtEnd() && isAlpha(peek())) {
            sb.append(advance());
        }
        return new Token(TokenType.IDENTIFICADOR, sb.toString());
    }

    private Token string() {
        StringBuilder sb = new StringBuilder();
        while (!isAtEnd() && peek() != '"') {
            sb.append(advance());
        }
        advance(); // consumir o último "
        return new Token(TokenType.STRING, sb.toString());
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private char advance() {
        return source.charAt(current++);
    }

    private char peek() {
        return source.charAt(current);
    }
}
