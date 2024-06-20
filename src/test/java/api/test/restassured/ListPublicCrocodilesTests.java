package api.test.restassured;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class ListPublicCrocodilesTests {
    @Test
    public void shouldListAllPublicCrocodiles() {
        RestAssured.baseURI = "https://test-api.k6.io";
        
        given().
        when().
            get("/public/crocodiles").
        then().
            assertThat().
            statusCode(200).
            body("size()", equalTo(8));
    }
}
