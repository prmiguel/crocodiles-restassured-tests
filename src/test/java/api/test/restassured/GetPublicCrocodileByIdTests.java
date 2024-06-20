package api.test.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetPublicCrocodileByIdTests {

    @Test
    public void shouldListAPublicCrocodile() {
        RestAssured.baseURI = "https://test-api.k6.io";
        
        given().
            pathParams("id", 1).
        when().
            get("/public/crocodiles/{id}").
        then().
            assertThat().
            statusCode(200).
            header("Content-Type", "application/json").
            body("id", equalTo(1)).
            body("name", equalTo("Bert")).
            body("sex", equalTo("M")).
            body("date_of_birth", equalTo("2010-06-27")).
            body("age", equalTo(13));
    }
}
