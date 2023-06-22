package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.AuthenticationHerOkuApp;

import static utils.AuthenticationHerOkuApp.generateToken;
/*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends a GET request to the URL
        Then
            Status code is 200
      And
         Among the data there should be someone whose firstname is "John" and last name is "Smith"
            (Data içerisinde firstname değeri "John", lastname değeri "Smith" olan biri olmalı)
     */

public class HerOkuAppBaseUrl {//jsonin ustunde kopy paste yaptik kopy yapinca isim degistirdik
   protected RequestSpecification  spec;//Her test methodu öncesi calisir
  //  RequestSpecification  interface oldugu icin obje olusturulamaz ,set BaseUriye base Url konulur
  //Build demeden bitmez
    @Before
public void setup() {//Before methodu calismazsa spec null olur exception atar ondan önce before calisacak sonra atama olacak

        spec = new RequestSpecBuilder()
                .addHeader("Cookie", "token="+ generateToken())
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restful-booker.herokuapp.com/")
                .build();

    }


    }
