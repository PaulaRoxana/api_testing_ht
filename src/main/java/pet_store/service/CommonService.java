package pet_store.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import pet_store.log.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URI, uri);

    protected RequestSpecification requestSpecification;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        requestSpecification.headers(headers);
    }

    protected Response getRequest(String uri) {
        Log.info("Sending the get request to the Uri" + prepareUri.apply(uri));
        Response response =  requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("Response body is " + response.asPrettyString());
        return response;
    }

    protected Response postRequest(String uri, Object body) {
        Log.info("Sending the post request to the Uri" + prepareUri.apply(uri));
        return requestSpecification.body(body).expect().statusCode(HttpStatus.SC_CREATED).log().ifError()
                .when().post(prepareUri.apply(uri));
    }

    protected void deleteRequest(String uri) {
        requestSpecification.expect().statusCode(HttpStatus.SC_NO_CONTENT).log().ifError()
                .when().delete(prepareUri.apply(uri));
    }
}
