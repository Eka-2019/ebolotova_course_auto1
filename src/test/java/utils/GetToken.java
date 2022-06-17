package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import pages.EndPointUrl;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static utils.GetBaseURL.BASE_URI;

public class GetToken {

    public static String getToken() {
        RestAssured.baseURI = BASE_URI;
        return given()
                .header("Authorization","Basic dWk6dWltYW4=")
                .post(EndPointUrl.TOKEN.addPath(String.format("?grant_type=password&username=%s&password=%s", "default", "1q2w3e")))
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("access_token");
    }
}
