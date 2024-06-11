package api.test.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ListPublicCrocodilesTests {
    @Test
    public void shouldListAllPublicCrocodiles() {
        when()
                .get("https://test-api.k6.io")
                .then()
                .statusCode(200);
    }
}
