package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.UserRequest;
import models.UserResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APITests {
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    public void successfulCreateUserTest() {
        UserRequest requestBody = new UserRequest("Kirill", "AQA Engineer");

        UserResponse responseBody = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract()
                .as(UserResponse.class);

        assertEquals("Kirill", responseBody.getName());
        assertEquals("AQA Engineer", responseBody.getJob());
    }
    @Test
    public void successfulGetUsersListTest() {
        given()
                .contentType(ContentType.JSON)
                .param("page", 2)
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("page", is(2))
                .body("data", not(empty()))
                .body("data.email", hasItem(containsString("@reqres.in")));
    }
}
