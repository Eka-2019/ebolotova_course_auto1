package utils;

import config.EndPointUrl;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static utils.GetBaseURL.BASE_URI;

public class GetToken {

    public static String getToken() {
        RestAssured.baseURI = BASE_URI;
        return given()
                .header("Authorization", "Basic dWk6dWltYW4=")
                .post(EndPointUrl.TOKEN.addPath(String.format("?grant_type=password&username=%s&password=%s", "default", "1q2w3e")))
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }

    public static String getStaticToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTY0MjUzMzIsInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMDY5MjY4ZTEtZWYyNi00NDczLThiNDYtZjRlM2QxMzQ3ZGY4IiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.ERAyh5LEPKVfeQ_ut-TfG3ML7QLzhgblPj91CNdzQg4";
    }
}
