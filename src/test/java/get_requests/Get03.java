package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {

   /*

Given    https://jsonplaceholder.typicode.com/todos/23
When   User send GET Request to the URL
Then   HTTP Status Code should be 200
And   Response format should be "application/json"
And  "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And  "completed" is false
And  "userId" is 2
   */

    @Test
    public void get03() {
//Set theUrl
        String url=" https://jsonplaceholder.typicode.com/todos/23";
 //Set the expected data
//Send the request and get the response
    Response response=given().get(url); response.prettyPrint();

 //Do assertion    Bodyde equlaTo icin corematchers.equalto yu kullandik
 //1.Yol
response.then().statusCode(200).contentType("application/json")
        .body("userId",equalTo(2))//bu uc bodyi asagida ayni satira koyarak soft assertion yapicaz
        .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
        .body("completed",equalTo(false));
//response.then hard assertion oluyor yani ilk failden sonrakilere artik bakmak ama bodyde soft assertion olabiliyor
// 2.Yol
        response.then().statusCode(200).contentType(ContentType.JSON).body("userId",equalTo(2),
                "title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit" ),
                        "completed",equalTo(false) );


//Tek body methodu icinde coklu assertion yaparak "soft assertion "yapabiliriz.Tüm fail durumlari hakkinda bilgi alabiliriz
//Coklu body methodlari icinde sadece hard assertion yapariz .Ilk hatada calisma durur ve sonraki assertionlar hakkinda bilgi alamayiz
    }
}
