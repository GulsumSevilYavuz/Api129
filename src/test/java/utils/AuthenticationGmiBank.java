package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

//    public static void main(String[] args) {
//        System.out.println(generateToken());
//    }

    public static String generateToken() {

        String body = "{ \"password\": \"Mark.123\", \"rememberMe\": true, \"username\": \"mark_twain\" }";

        Response response = given().contentType(ContentType.JSON).body(body).post("https://gmibank.com/api/authenticate");


        return response.jsonPath().getString("id_token");
    }

}