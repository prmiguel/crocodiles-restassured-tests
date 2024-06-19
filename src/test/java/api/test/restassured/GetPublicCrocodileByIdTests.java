package api.test.restassured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetPublicCrocodileByIdTests {
    @Test
    public void shouldListAPublicCrocodile() {
        when()
                .get("https://test-api.k6.io/public/crocodiles/1")
                .then()
                .statusCode(200);
    }
}
