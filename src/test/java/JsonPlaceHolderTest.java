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
                "\"userId\":1\n" +
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

    @Test
    public void POST() {
        String postBodyJson = "{\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";
        given()
                .body(postBodyJson)
                .log().uri()
                .when().post(JSON_PLACE_HOLDER_POST)
                .then()
                .log().body()
                .statusCode(201);
    }

    @Test
    public void PostWithXML() {

        /**XML from https://www.tutorialspoint.com/online_xml_editor.htm
         * XML service https://pipedream.com/workflows*/

        String postXMLBody = "\t<Company>\n" +
                "\t\t\t  <Employee>\n" +
                "\t\t\t\t  <FirstName>Tanmay</FirstName>\n" +
                "\t\t\t\t  <LastName>Patil</LastName>\n" +
                "\t\t\t\t  <ContactNo>1234567890</ContactNo>\n" +
                "\t\t\t\t  <Email>tanmaypatil@xyz.com</Email>\n" +
                "\t\t\t\t  <Address>\n" +
                "\t\t\t\t\t   <City>Bangalore</City>\n" +
                "\t\t\t\t\t   <State>Karnataka</State>\n" +
                "\t\t\t\t\t   <Zip>560212</Zip>\n" +
                "\t\t\t\t  </Address>\n" +
                "\t\t\t  </Employee>\n" +
                "\t\t\t</Company>";

        given()
                .body(postXMLBody)
                .log().uri()
                .when().post(XML_REQUEST_BIN_POST)
                .then()
                .log().body()
                .statusCode(200);
    }
}
