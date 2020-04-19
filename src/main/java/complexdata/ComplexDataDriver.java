package complexdata;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ComplexDataDriver {
    public static void main(String[] args) {
        String complexDataStr = "JOHN 28 1234567890 (123)456-7890 01-JAN-1970\n" +
            "HARRY 50 8888888888 (666)666-6666 01-JAN-1971";

        CharStream is = CharStreams.fromString(complexDataStr);
        ComplexDataLexer lexer = new ComplexDataLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ComplexDataParser parser = new ComplexDataParser(tokens);
        parser.setBuildParseTree(true);

        ComplexDataParser.StartRuleContext startRuleContext = parser.startRule();

        TestComplexDataVisitor visitor = new TestComplexDataVisitor();
        List<ComplexData> complexDataList = startRuleContext.accept(visitor);

        complexDataList.stream().forEach(data -> System.out.println(data));
    }
}
