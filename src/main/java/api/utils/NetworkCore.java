package api.utils;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class NetworkCore {

    protected Response response;
    protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    protected JSONObject responseBody;

    public void sendRequestAndGetResponse(Method method, int code) { //где method - метод запроса (GET,POST...), code - статус код ответа сервера. Метод отправляет запрос и получает ответ и проверяет статус код
        response = given()
                .spec(requestSpecBuilder.build())
                .log()
                .uri()
                .log()
                .parameters()
                .when()
                .request(method);
        response.then().assertThat().statusCode(code);
    }
}
