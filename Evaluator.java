
import java.io.File;
import java.io.FileInputStream;

public class Evaluator {

    public static void main(String args[]) {
        try {
            MeuLexer lexer = new MeuLexer(new FileInputStream(new File("input.in")));
            MeuParser parser = new MeuParser(lexer);
            System.out.println("Starting Expression Parsing");
            parser.expr();
            System.out.println("Parsing finished Sucessfully");

        } catch (Exception ex) {
            System.err.println("ERROR - " + ex.getMessage());
        }
    }
}
