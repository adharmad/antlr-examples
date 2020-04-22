package simplejson;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.Map;

public class SimpleJsonDriver {
    public static void main(String[] args) {
        String jsonStr = "{\"attr1\" : \"val1\"," +
                "\"attr2\" : \"val2\"," +
                "\"attrjson1\" : {" +
                "\"attr3\" : \"val3\"," +
                "\"attr4\" : \"val4\"" +
                "}," +
                "\"attr5\" : \"val5\"" +
                "}";

        CharStream is = CharStreams.fromString(jsonStr);
        SimpleJsonLexer lexer = new SimpleJsonLexer(is);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleJsonParser parser = new SimpleJsonParser(tokens);
        parser.setBuildParseTree(true);

        SimpleJsonParser.JsonContext jsonContext = parser.json();

        TestSimpleJsonVisitor visitor = new TestSimpleJsonVisitor();
        Map<String, Object> jsonMap = jsonContext.accept(visitor);

        System.out.println(jsonMap);
    }
}
