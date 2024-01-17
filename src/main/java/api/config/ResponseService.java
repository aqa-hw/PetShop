package api.config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.hc.core5.http.HttpStatus;

import static io.restassured.filter.log.LogDetail.ALL;

public class ResponseService {

    public static ResponseSpecification ok() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .log(ALL)
                .build();
    }

    public static ResponseSpecification userDeleted() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NOT_FOUND)
                .log(ALL)
                .build();
    }
}
