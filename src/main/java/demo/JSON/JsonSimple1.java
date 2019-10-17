package demo.JSON;

import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonSimple1 {

    public static void main(String[] args) throws IOException {
        Staff staff = createStaff();
        String json = Jsoner.serialize(staff);
        json = Jsoner.prettyPrint(json);
        System.out.println(json);

        try (FileWriter fileWriter = new FileWriter("user3.json")){
            Jsoner.serialize(staff,fileWriter);
        }
    }

    private static Staff createStaff(){

        Staff staff = new Staff();
        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{"Founder","CTO","Writer"});
        Map<String, BigDecimal> salary = new HashMap(){
            {
                put("2010",new BigDecimal(10000));
                put("2012",new BigDecimal(12000));
                put("2018",new BigDecimal(14000));
            }
        };
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java","pathon","node"));
        return staff;





    }
}
