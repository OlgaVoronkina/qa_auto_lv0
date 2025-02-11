package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://crudcrud.com/api/792faec9fec64d04b9ccfac0ace61040";
    }
    @Test
    public void userShouldBeAbleCreateStudent(){
        //given - When - then BDD
        StudentRequests.createStudent("{\n" +
                "    \"name\": \"Саша Иванов\",\n" +
                "    \"grade\":8\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent(){
        //Step 1: user creation
        String id = StudentRequests.createStudent("{\n" +
                        "    \"name\": \"Саша Иванов2\",\n" +
                        "    \"grade\":8\n" +
                        "}");

        //Step 2: removing a user
        StudentRequests.removeStudent(id);

        //Step 3: Check user unavailability
        given()
                .get("/student/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
