package demo.annotation.demo2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.sun.javafx.collections.MappingChange;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {

    public static Class clazz;

    public ObjectToJsonConverter(Object object) {
        ref(object);
    }

    public Object ref(Object object){
         ;
        return this.clazz = object.getClass();
    }


    public  String convertToJson(Object object) throws JsonSerializationException {
        try {

            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);

        }catch (Exception e){
            throw new JsonSerializationException(e.getMessage());
        }
    }

    //检查类是否实例化，是否是指定注解类
    private void checkIfSerializable(Object object){
        if (Objects.isNull(object)){
            throw new JsonSerializationException("Can't serialize a null object");
        }

        //判断类是不是注解类
        if (!clazz.isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializationException("this class "+clazz.getSimpleName()
                    +" is not annotated with JsonSerializable");

        }

    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method :clazz.getDeclaredMethods()
             ) {
            //如果是指定Init注解的方法
            if (method.isAnnotationPresent(Init.class)){
                //设置方法可见
                method.setAccessible(true);
                //调用方法
                method.invoke(object);


            }
        }

    }


    private String getJsonString(Object object) throws IllegalAccessException {
        Map<String,String> jsonElementsMap= new HashMap<>();

        for (Field field:clazz.getDeclaredFields()
             ) {
            //是否是指定注解的元素
            if (field.isAnnotationPresent(JsonElement.class)){
                //设置字段可见
                field.setAccessible(true);
                //插入到jsonElementMap中
                jsonElementsMap.put(getKey(field),(String) field.get(object));

            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
        
    }

    private String getKey(Field field){
        //获取字段的注解的返回值
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() :value;
    }





}
