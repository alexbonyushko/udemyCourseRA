import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.JSON_PLACE_HOLDER_GET;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {
    @Test
    public void GET() {
        given()
                .queryParam("postId", 1)
                .log()
                .uri()
                .when()
                .get(JSON_PLACE_HOLDER_GET)
                .then()
                .log()
                .body()
                .statusCode(200);
    }
}
