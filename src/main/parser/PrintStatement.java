package main.parser;

public class PrintStatement implements Statement {
    private final String message;

    public PrintStatement(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "PrintStatement(\"" + message + "\")";
    }
}
