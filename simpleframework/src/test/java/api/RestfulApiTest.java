package api;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestfulApiTest {

    @Test
    public void validateResponseSchema() {

        // 1️⃣ Base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // 2️⃣ GET + Schema Validation
        given()
            .header("Content-Type", "application/json")
        .when()
            .get("/objects/7")
        .then()
            .log().all()
            .assertThat().statusCode(200)
            .assertThat()
            .body(matchesJsonSchemaInClasspath("Schema1.json"));
    }
}
