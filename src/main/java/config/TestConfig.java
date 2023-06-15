package config;

import io.restassured.builder.RequestSpecBuilder;
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
import static constants.Constants.Servers.XML_REQUEST_BIN_URL;

public class TestConfig {

    /**уникальная спецификация для запроса*/
    protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder() /**&#x443;&#x43D;&#x438;&#x43A;&#x430;&#x43B;&#x44C;&#x43D;&#x430;&#x44F; &#x441;&#x43F;&#x435;&#x446;&#x438;&#x444;&#x438;&#x43A;&#x430;&#x446;&#x438;&#x44F; &#x434;&#x43B;&#x44F; &#x437;&#x430;&#x43F;&#x440;&#x43E;&#x441;&#x430;*/
            .addHeader("Content-Type", "application/xml")
            .addCookie("testCokieXML")
            .setBaseUri(XML_REQUEST_BIN_URL)
            .build(); /**уникальная спецификация для запроса*/

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
        /**общая спецификация для запроса*/
        RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .addCookie("testCokieJSON")
                .build();
        RestAssured.requestSpecification = requestSpecificationJson;
    }
}
