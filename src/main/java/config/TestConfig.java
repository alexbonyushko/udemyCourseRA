package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.BeforeClass;


import io.restassured.RestAssured;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static constants.Constants.RunVariable.server;
import static constants.Constants.RunVariable.path;
import static constants.Constants.Servers.SWAPI_URL;
import static constants.Constants.Servers.XML_REQUEST_BIN_URL;

public class TestConfig {

    /**
     * уникальная спецификация для запроса
     */
    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/xml")
            .addCookie("testCokieXML")
            .setBaseUri(XML_REQUEST_BIN_URL)
            .build();

    /**общая спецификация для запроса*/
   protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .addCookie("testCokieJSON")
            .build();

    /**общая спецификация для ответа, для вынесения общих признаков и общих проверок для всех тестов*/
   protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
           .expectStatusCode(200)
           .build();
   protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
           .expectStatusCode(201)
           .build();

   /**спецификация для тест swapi*/
   protected RequestSpecification requestSpecificationForSwapiTests = new RequestSpecBuilder()
           .setBaseUri(SWAPI_URL)
           .build();


    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

    }
}
