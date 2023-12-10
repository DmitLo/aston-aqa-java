package org.example;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class ApiTest {

    @Test(priority = 1)
    public void testGetRequest(){

        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void testGetRequestWithDataValidation(){

        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200)
                .and()
                .body("foo1" )

    }




}
