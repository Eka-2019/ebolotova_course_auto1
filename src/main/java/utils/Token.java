package utils;

import config.EndPointUrl;
import io.restassured.RestAssured;

import static utils.BaseURL.BASE_URI;

public class Token {

    public static String getToken() {
        RestAssured.baseURI = BASE_URI;
        return RestAssured.given()
                .header("Authorization", "Basic dWk6dWltYW4=")
                .post(EndPointUrl.TOKEN.addPath(String.format("?grant_type=password&username=%s&password=%s", "default", "1q2w3e")))
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }
}
