package demo.JSON;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import java.io.FileReader;
import java.io.IOException;

public class JsonSimple2 {
    public static void main(String[] args) throws IOException, JsonException {
        try (
                FileReader fileReader  = new FileReader("user3.json")
        ){
            JsonObject deserialize = (JsonObject) Jsoner.deserialize(fileReader);

            Mapper mapper = new DozerBeanMapper();

            Staff staff = mapper.map(deserialize,Staff.class);
            System.out.println(staff);

        }
    }
}
