package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private final String URI = "https://postman-echo.com";
    private String body = "This is expected to be sent back as part of response body.";

    @Test
    public void getRequestsTest() {
        Response response = given().baseUri(URI)
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

                Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
                Map<String, String> args = response.jsonPath().getMap("args", String.class, String.class);
                String factualURL = response.jsonPath().getString("url");

        Assertions.assertAll(
                () -> Assertions.assertTrue(args.get("foo1").contains("bar1")),
                () -> Assertions.assertTrue(args.get("foo2").contains("bar2")),
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals("gzip,deflate", headers.get("accept-encoding")),
                () -> Assertions.assertEquals(URI + "/get?foo1=bar1&foo2=bar2", factualURL)
        );

    }

    @Test
    public void postRawTextTest() {
       Response response = given()
                .log().body()
                .baseUri(URI)
                .contentType(ContentType.TEXT).body(body)
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

       Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
       String data = response.jsonPath().getString("data");
       String actualURL = response.jsonPath().getString("url");
       String json = response.jsonPath().getString("json");

        Assertions.assertAll(
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals(Integer.toString(data.length()), headers.get("content-length")),
                () -> Assertions.assertEquals(body, data),
                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", headers.get("content-type")),
                () -> Assertions.assertEquals(URI + "/post", actualURL),
                () -> Assertions.assertNull(json)
        );
    }

    @Test
    public void postFromDataTest() {
        Response response = given()
                .log().body()
                .baseUri(URI)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1").formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
        Map<String, String> form = response.jsonPath().getMap("form", String.class, String.class);
        Map<String, String> json = response.jsonPath().getMap("json", String.class, String.class);
        String actualURL = response.jsonPath().getString("url");
        String data = response.jsonPath().getString("data");



        Assertions.assertAll(
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals("19", headers.get("content-length")),
                () -> Assertions.assertEquals("", data),
                () -> Assertions.assertEquals("bar1", form.get("foo1")),
                () -> Assertions.assertEquals("bar2", form.get("foo2")),
                () -> Assertions.assertEquals("bar1", json.get("foo1")),
                () -> Assertions.assertEquals("bar2", json.get("foo2")),
                () -> Assertions.assertEquals(URI + "/post", actualURL)
        );


    }

    @Test
    public void putRequestTest() {
        Response response = given()
                .log().body()
                .baseUri(URI).contentType(ContentType.TEXT).body(body)
                .when().put("/put")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
        String json = response.jsonPath().getString("json");
        String actualURL = response.jsonPath().getString("url");
        String data = response.jsonPath().getString("data");

        Assertions.assertAll(
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals(body, data),
                () -> Assertions.assertEquals(Integer.toString(data.length()), headers.get("content-length")),
                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", headers.get("content-type")),
                () -> Assertions.assertEquals(URI + "/put", actualURL),
                () -> Assertions.assertNull(json)
        );
    }

    @Test
    public void patchRequestTest() {
        Response response = given()
                .log().body()
                .baseUri(URI).contentType(ContentType.TEXT).body(body)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
        String json = response.jsonPath().getString("json");
        String actualURL = response.jsonPath().getString("url");
        String data = response.jsonPath().getString("data");

        Assertions.assertAll(
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals(body, data),
                () -> Assertions.assertEquals(Integer.toString(data.length()), headers.get("content-length")),
                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", headers.get("content-type")),
                () -> Assertions.assertEquals(URI + "/patch", actualURL),
                () -> Assertions.assertNull(json)
        );
    }

    @Test
    public void deleteRequestTest() {
        Response response = given()
                .log().body()
                .baseUri(URI).contentType(ContentType.TEXT).body(body)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Map<String, String> headers = response.jsonPath().getMap("headers", String.class, String.class);
        String json = response.jsonPath().getString("json");
        String actualURL = response.jsonPath().getString("url");
        String data = response.jsonPath().getString("data");

        Assertions.assertAll(
                () -> Assertions.assertEquals(URI.split("//")[1], headers.get("host")),
                () -> Assertions.assertEquals(15, headers.get("x-request-start").length()),
                () -> Assertions.assertTrue(headers.get("x-request-start").contains("t")),
                () -> Assertions.assertEquals("close", headers.get("connection")),
                () -> Assertions.assertEquals("https", headers.get("x-forwarded-proto")),
                () -> Assertions.assertEquals("443", headers.get("x-forwarded-port")),
                () -> Assertions.assertTrue(headers.get("x-amzn-trace-id").contains("Root")),
                () -> Assertions.assertEquals(body, data),
                () -> Assertions.assertEquals(Integer.toString(data.length()), headers.get("content-length")),
                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", headers.get("content-type")),
                () -> Assertions.assertEquals(URI + "/delete", actualURL),
                () -> Assertions.assertNull(json)
        );
    }
}
