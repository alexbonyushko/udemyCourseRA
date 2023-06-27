import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


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

    @Test
    public void getSomeFieldInResponseAssertion() {
        given()
                .spec(requestSpecificationForSwapiTests)
                .log()
                .uri()
                .when()
                .get(SWAPI_PATH)
                .then()
                .body("people", equalTo("https://swapi.dev/api/people/")) //library Hamcrest
                .log()
                .body();
    }

    @Test
    public void getSomeFieldInResponseWithIndexAssertion() {
        given()
                .spec(requestSpecificationForSwapiTests)
                .log()
                .uri()
                .when()
                .get(SWAPI_PATH + SWAPI_GET_PEOPLE)
                .then()
                .body("count", equalTo(82)) //library Hamcrest
                .body("results.name[0]", equalTo("Luke Skywalker")) //library Hamcrest
                .log()
                .body();
    }
}
