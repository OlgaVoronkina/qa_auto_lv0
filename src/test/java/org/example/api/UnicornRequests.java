package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.example.api.models.Student;
import org.example.api.models.Unicorn;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static Unicorn createUnicorn(Unicorn unicorn){
        String jsonUnicorn = UnicornRequests.mappingUnicorn(unicorn);
        return given()
                .body(jsonUnicorn)
                .contentType(ContentType.JSON)
                .when()
                .post("/unicorn")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"))
                .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
    }

    public void removeUnicorn(String id){
        given()
                .when()
                .delete("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(200);
    }

    public static Unicorn changeUnicorn(String id, Unicorn unicorn){
        String jsonUnicorn = UnicornRequests.mappingUnicorn(unicorn);
        System.out.println(jsonUnicorn);
        return given()
                .body(jsonUnicorn)
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
    }

    public Unicorn getUnicorn(String id, int statusCode){
        return given()
                .when()
                .get("/unicorn/"+id)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static String mappingUnicorn(Unicorn unicorn){
        String json =null;
        try {
            json = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
