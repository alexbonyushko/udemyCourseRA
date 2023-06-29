package tests;

import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
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

    @Test
    public void getAllDataFromRequest() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .when()
                        .get(SWAPI_PATH)
                        .then()
                        .extract()
                        .response();
        String jsonResponseString = response.asString();
        System.out.println(jsonResponseString);
    }

    @Test
    public void getCookieFromResponse() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .when()
                        .get(SWAPI_PATH)
                        .then()
                        .extract() //вытаскиваем необходимые нам параметры из тела ответа
                        .response();
        Map<String, String> allCoolies = response.getCookies();
        System.out.println("allCookies--> " + allCoolies);

        String someCookie = response.getCookie("1");
        System.out.println("someCookies--> " + someCookie);
    }

    @Test
    public void getHeadersFromResponse() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .when()
                        .get(SWAPI_PATH)
                        .then()
                        .extract()//вытаскиваем необходимые нам параметры из тела ответа
                        .response();
        Headers headers = response.getHeaders();
        System.out.println("allHeaders--> \n" + headers);
        String contentType = response.getHeader("Content-Type");
        System.out.println("\nContent-Type --> " + contentType);
    }

    @Test
    public void validateXmlSchema() {
        given()
                .log()
                .uri()
                .when()
                .get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?key=___&input=New York&inputtype=textquery&fields=formatted_address,geometry,icon,name,photo,place_id,plus_code,type&language=en")//в значение key необходимо передать ключ который мы сгенерировали в ЛК Goggle Place API
                .then()
                .body(matchesXsdInClasspath("xmlSchema.xsd"))
                .log()
                .body();
    }

    @Test
    public void validateJsonExample() {
        given()
                .log()
                .uri()
                .when()
                .get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?key=___&input=New York&inputtype=textquery&fields=formatted_address,geometry,icon,name,photo,place_id,plus_code,type&language=en")//в значение key необходимо передать ключ который мы сгенерировали в ЛК Goggle Place API
                .then()
                .body(matchesJsonSchemaInClasspath("jsonSchema.json"))
                .log()
                .body();
    }

    @Test
    public void getMapOfElementsWithSomeKey() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .log()
                        .uri()
                        .when()
                        .get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        System.out.println("response:\n" + response.asString())
        ;
        Map<String, ?> someObject = response
                .path("results.find {it.name = 'C-3PO'}");//Groovy GPath
        System.out.println("someObject-->\n" + someObject);
    }

    @Test
    public void getSingleElementWithSomeKey() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .log()
                        .uri()
                        .when()
                        .get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        String url = response
                .path("results.find {it.name = 'C-3PO'}.url");//Groovy GPath
        System.out.println("url-->\n" + url);
    }

    @Test
    public void getAllElementsWithSomeKey() {
        Response response =
                given()
                        .spec(requestSpecificationForSwapiTests)
                        .log()
                        .uri()
                        .when()
                        .get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        List films = response.path("results.findAll {it.films}.name");//Groovy GPath
        System.out.println("films:\n" + films);
    }
}
