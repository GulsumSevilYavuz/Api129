package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ObjectMapperUtils {
   // Map<String, Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
    //T herhangi bir Type//Generic Method
    //Object kendi bi data tipidir bu herhangi bi data tipini temsil eder
    //Object yapaprsak type casting yapmak zorunda kaliriz
   //readValue() methodu birinci paramtrede aldığı String Json datayı ikinci paramterde belirtilen data tipine çevirir.
public static <T>T convertJsonToJava(String json,Class<T> cls)  {//Class<T> cls =>Herhangi bi class data tipi adi cls
    try {
        return   new ObjectMapper().readValue(json, cls);
    } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }


}
}
