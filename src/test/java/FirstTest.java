import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.*;


public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest() {
        given()
                .log()
                .all() /** логируем весь запрос*/
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .log()
                .all() /**логируем весь ответ*/
                .statusCode(200);
    }

    @Test
    public void myFirstTestLogUriBody() {
        given()
                .log()
                .uri() /**логируем только uri*/
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .log()
                .body()/**логируем только тело ответа*/
                .statusCode(200);
    }

    @Test
    public void myFirstTestIfError() {
        given()
                .log()
                .ifValidationFails() /** логируем только в случае ошибки*/
                .when()
                .get(SWAPI_GET_PEOPLE + "1")
                .then()
                .log()
                /**.all()* - весь ответ*/
                .body()
                .statusCode(201);
    }
}
