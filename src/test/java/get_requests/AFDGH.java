package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AFDGH {
      /* Given
    https://automationexercise.com/api/productsList
    When
    User sends Get request
    Then
    Assert that number of "Women" usertype is 12
            (Kadın usertype sayısının 12 olduğunu doğrulayın)

    Not: Yazdırmayı jsonPath kullanarak yapınız: response.jsonPath().prettyPrint();

*/

   /* @Test
    public void automationExerciseTest() {
        AutomationExerciseBaseUrl automationExerciseBaseUrl = new AutomationExerciseBaseUrl();
        automationExerciseBaseUrl.setUp();
        automationExerciseBaseUrl.spec.pathParam("first", "productsList");
        Response response = given(automationExerciseBaseUrl.spec).get("{first}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();*/

    @Test
    public void automationExerciseTest(){
        Response response = given().get("https://automationexercise.com/api/productsList");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        //Assert that number of "Women" usertype is 12 -->Kadın usertype sayısının 12 olduğunu doğrulayın
        int kadinUserTypeSayisi = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        System.out.println(kadinUserTypeSayisi);
        assertEquals(12,kadinUserTypeSayisi);


    }}
