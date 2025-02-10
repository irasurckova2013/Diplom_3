package Rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {
    private final RequestSpecification baseRequestSpec = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.nomoreparties.site/")
            .addHeader("Content-Type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    protected Response doPostRequest(String path, String body) {
        return given()
                .spec(baseRequestSpec)
                .body(body)
                .post(path)
                .thenReturn();

    }

    protected Response doDeleteRequest(String path, String token) {
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .delete(path)
                .thenReturn();
    }

}