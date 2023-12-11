package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ApiTest {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }


    @Test(priority = 1)
    public void testGetRequest() {

        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void testGetRequestWithDataValidation() {

        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .and()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test(priority = 3)
    public void testPostRequestWithDataValidation() {

        // Определяем тело запроса (JSON, XML и т.д.)
        String requestBody = "{\"test\": \"value\"}";
        // Выполняем POST-запрос и сохраняем ответ
        Response response = RestAssured.given()
                .contentType(ContentType.JSON) // Устанавливаем тип содержимого тела запроса
                .body(requestBody) // Устанавливаем тело запроса
                .post("/post"); // Указываем конечную точку (endpoint)
        // Выводим детали ответа
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("value", response.getBody().jsonPath().getString("data.test"));
    }

    @Test(priority = 4) //
    public void testPostRequest() {

        String requestBody = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }

    @Test(priority = 5)
    public void testPutRequest() {

        String requestBody = "{\"data\" : \"This is expected to be sent back as part of response body.\"}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("[data:This is expected to be sent back as part of response body.]", response.jsonPath().getString("data"));
    }

    @Test(priority = 6)
    public void testPatchRequest() {

        String requestBody = "{\"data\" : \"This is expected to be sent back as part of response body.\"}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("[data:This is expected to be sent back as part of response body.]", response.jsonPath().getString("data"));
    }

    @Test(priority = 7)
    public void testDeleteRequest() {

        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "postman-token "
                + "e6aacf6a-4dd2-4f2b-946d-c1df740f0f22").header("Content-Type", "application/json");

        // Calling the Delete API with request body
        Response res = httpRequest.body("{ \"data\": \"This is expected to be sent back as part of response body.\"}").delete("/delete");
        // Fetching the response code from the request and validating the same
        Assert.assertEquals(res.getStatusCode(),200);
    }
}

