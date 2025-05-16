package main.lexer;

public class Token {
    private final TokenType type;
    private final String lexeme;

    public Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public TokenType getTipo() {
        return type;
    }

    public String getLexema() {
        return lexeme;
    }

    @Override
    public String toString() {
        return String.format("Token { tipo = %-15s, lexema = \"%s\" }", type, lexeme);
    }
}
