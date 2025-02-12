package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://crudcrud.com/api/de49edaa52924e1682be647b79f6c244";
    }
    @Test
    public void userShouldBeAbleCreateStudent(){
        Student student = Student.builder()
                .name("Саша Иванов")
                .grade(8)
                .build();
        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent(){
        //Step 1: user creation

        Student student = Student.builder()
                .name("Саша Иванов")
                .grade(8)
                .build();
        Student createdStudent = StudentRequests.createStudent(student);

        //Step 2: removing a user
        StudentRequests.removeStudent(createdStudent.getId());

        //Step 3: Check user unavailability
        given()
                .get("/student/" + createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
