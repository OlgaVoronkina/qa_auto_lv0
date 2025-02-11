package org.example.api;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public String createUnicorn(String body){
        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/unicorn")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract()
                .path("_id");
    }

    public void removeUnicorn(String id){
        given()
                .when()
                .delete("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public void changeUnicorn(String id, String body){
        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public String getUnicorn(String id, int statusCode){
        return given()
                .when()
                .get("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .path("tailColor");
    }
}
