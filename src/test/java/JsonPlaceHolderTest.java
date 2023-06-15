import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;
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

    @Test
    public void PUT() {

        String putBodyJson = "{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}\n";

        given()
                .body(putBodyJson)
                .log()
                .uri()
                .when()
                .put(JSON_PLACE_HOLDER_PUT)
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void DELETE() {
        given()
                .log()
                .uri()
                .when()
                .delete(JSON_PLACE_HOLDER_DELETE)
                .then()
                .log()
                .body()
                .statusCode(200);

    }
}
