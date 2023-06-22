package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get04  extends JsonPlaceHolderBaseUrl {
       /*
Given   https://jsonplaceholder.typicode.com/todos
When   I send a GET request to the Url
And   Accept type is "application/json" //Request gönderirken accept typeinida belirle
                                            diyor yani and when kisminda then degil dogrulama istemiyor<= <= önemli
Andde bunu istiyor          =>accept typei belirledik         Response response=given(spec).accept(ContentType.JSON).get("{first}")
Then    HTTP Status Code should be 200
And   Response format should be "application/json"
And   There should be 200 todos => Toplam 200 todos olmali
And   "quis eius est sint explicabo" should be one of the todos title => en az bir baslik bu olmali
And    2, 7, and 9 should be among the userIds

*/

    @Test
    public void get04() {
//Set the url
// String url="https://jsonplaceholder.typicode.com/todos";=> bu tavsiye edilmez
//Base url specten geldi
spec .pathParam("first","todos");//Base url esadece todos yani bi parametre ekledik first birinci parametre
// Set the expected data

//Send the request and get the response
Response response=given(spec).accept(ContentType.JSON).get("{first}");
//=> given().get(url) yerine base urli givene koyduk kalan parametreyi getin icine koyduk{}bu sart
//response.prettyPrint();
//Do Assertion  § body sorgusu var ondan dolayi 3 kez yazdik  bu bi list her elemandan 200 kez gelir
        response.then().statusCode(200).contentType(ContentType.JSON).body("title", hasSize(201))
                .body("title",hasItem("quis eius est sint explicabo")) //<= hasItem contains demek
                .body("userId",hasItems(2,7,9));
//body("",hasSize(200))  ilk parametreyi bos birakirsam hepsi birden gelir list olarak
//hasSize =>eleman sayisini assert eder
//hasItem =>contains methodu gibi bir objenin icerilip icerilmedigini kontrol eder
//hasItems => containsAll methodu gibi birden cok objenin icerililip icerilmedigini assert eder
    }

}
