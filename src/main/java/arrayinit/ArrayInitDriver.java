package arrayinit;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ArrayInitDriver {
    public static void main(String[] args) {
        //String arrayStmt = "{1, 2, 3}";
        String arrayStmt = "{1, 2, 3, {4, 5, 6, {7, 8, 9}}}";

        CharStream is = CharStreams.fromString(arrayStmt);
        ArrayInitLexer lexer = new ArrayInitLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        parser.setBuildParseTree(true);

        ParseTree tree = parser.init(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}
