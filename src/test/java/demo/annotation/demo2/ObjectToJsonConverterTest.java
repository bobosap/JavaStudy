package demo.annotation.demo2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectToJsonConverterTest {

    @Test
    public void convertToJson() {
        Person person = new Person("bo","wang","18");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter(person);
        String jsonString = serializer.convertToJson(person);
        assertEquals("{\"personAge\":\"18\",\"firstName\":\"Bo\",\"lastName\":\"Wang\"}",jsonString);
    }
}