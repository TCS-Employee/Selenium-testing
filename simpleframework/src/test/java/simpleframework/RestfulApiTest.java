package simpleframework;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestfulApiTest {

    @Test
    public void getObjectByHardcodedId() {

        // Base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Simple GET (hard-coded)
        given()
        .when()
            .get("/objects/7")
        .then()
            .log().all()
            .assertThat().statusCode(200)
            .assertThat().body("id", equalTo("7"));
    }

    @Test
    public void getObjectUsingPathParam() {

        // Base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // GET using path parameter
        given()
            .pathParam("id", "7")
        .when()
            .get("/objects/{id}")
        .then()
            .log().all()
            .assertThat().statusCode(200)
            .assertThat().body("id", equalTo("7"));
    }

    @Test
    public void getDifferentIdUsingPathParam() {

        // Base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // GET using path parameter with different id
        given()
            .pathParam("id", "3")
        .when()
            .get("/objects/{id}")
        .then()
            .log().all()
            .assertThat().statusCode(200)
            .assertThat().body("id", equalTo("3"));
    }
}
