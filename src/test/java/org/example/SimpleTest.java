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
        RestAssured.baseURI="https://crudcrud.com/api/71ee3b9d43b14b2490a67712f453c282";
    }
    @Test
    public void userShouldBeAbleCreateStudent(){
        //given - When - then BDD
        //сериализация из json в объект и наоборот
        Student student = new Student("Саша Иванов", 8);
        StudentRequests.createStudent(student.toJson());
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent(){
        //Step 1: user creation

        Student student = new Student("Саша Иванов", 8);
        String id = StudentRequests.createStudent(student.toJson());

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
