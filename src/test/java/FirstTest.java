import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;

/**
 * 7.First Test
 */
public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest() {
        given()
                .when()
                .get(SWAPI_GET_PEOPLE+"1")
                .then()
                .statusCode(200);
    }
}
