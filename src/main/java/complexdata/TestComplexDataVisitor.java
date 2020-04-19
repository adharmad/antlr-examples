package complexdata;

import java.util.ArrayList;
import java.util.List;

public class TestComplexDataVisitor extends ComplexDataBaseVisitor<List<ComplexData>> {
    @Override
    public List<ComplexData> visitStartRule(ComplexDataParser.StartRuleContext ctx) {
        List dataList = new ArrayList();

        for (int i=0 ; i<ctx.NAME().size() ; i++) {
            String name = ctx.NAME(i).getText();
            int age = Integer.parseInt(ctx.NUM(2*i).getText());
            long ssn = Long.parseLong(ctx.NUM(2*i+1).getText());
            String tel = ctx.TEL(i).getText();
            String dob = ctx.DOB(i).getText();

            ComplexData complexData = new ComplexData(name, age, ssn, tel, dob);
            dataList.add(complexData);
        }

        return dataList;
    }
}
