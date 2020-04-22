package simplejson;

import java.util.HashMap;
import java.util.Map;

public class TestSimpleJsonVisitor extends SimpleJsonBaseVisitor<Map<String, Object>> {
    @Override
    public Map<String, Object> visitJson(SimpleJsonParser.JsonContext ctx) {
        Map<String, Object> retMap = new HashMap<>();

        ctx.elem().stream().forEach(elemContext -> {
            retMap.putAll(elemContext.accept(this));
        });

        return retMap;
    }

    @Override
    public Map<String, Object> visitElem(SimpleJsonParser.ElemContext ctx) {
        Map<String, Object> retMap = new HashMap<>();

        if (ctx.ID().size() > 1) {
            retMap.put(ctx.ID(0).getText(), ctx.ID(1).getText());
        } else {
            retMap.put(ctx.ID(0).getText(), ctx.json().accept(this));
        }

        return retMap;
    }
}
