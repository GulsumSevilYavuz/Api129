package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonPlaceHolderBaseUrl {
/*
Given
     1)https://jsonplaceholder.typicode.com/todos/198
     2){
        "userId":21,
        "title":"Wash the dishes",
        "vopmletet":false
        }
        When
             I send PUT Request to the Url
        Then
            Status code is 200
            And response body is like  {
                                        "useId":21,
                                        "title":" Wash the dishes",
                                        "completet":false
                                        "id":198
 */
    @Test
    public void put01() {
        //Set the Url
        spec.pathParams("first", "todos", "second", "198");
        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 21);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completet", false);

        System.out.println("expectedData=" + expectedData);
        //Send the request and  get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();
//Do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De_Serialization=>Jason to Java
        System.out.println("actualData=" + actualData);
        //       Assert.assertEquals(expectedData,actualData); Responseda Idde var yani tamamen ayni degiller böyle assertion yapilmaz
        Assert.assertEquals(expectedData.get("completet"), actualData.get("completet "));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
        @Test
        public void put01b(){
        //Set the Url
         // spec.pathParams("first","todos","second","198");
          // Set the expected data
     JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
    Map<String,Object>expectedData=jsonPlaceHolderTestData.expectedDataMapMethod(21,"Wash the dishes",false);
            System.out.println("expectedData=" + expectedData);
            //Send the request and  get the response
            Response response = given(spec).body(expectedData).put("{first}/{second}");
            response.prettyPrint();
            //Do Assertion
            Map<String, Object> actualData = response.as(HashMap.class);//De_Serialization=>Jason to Java
            System.out.println("actualData=" + actualData);
            //       Assert.assertEquals(expectedData,actualData); Responseda Idde var yani tamamen ayni degiller böyle assertion yapilmaz
            Assert.assertEquals(expectedData.get("completet"), actualData.get("completet "));
            Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
            Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        }
    }

