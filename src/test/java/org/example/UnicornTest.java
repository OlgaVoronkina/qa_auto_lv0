package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UnicornTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://crudcrud.com/api/71ee3b9d43b14b2490a67712f453c282";
    }
    @Test
    public void userShouldBeAbleCreateUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        unicornRequests.createUnicorn("{\n" +
                "    \"name\": \"Белка\",\n" +
                "    \"tailColor\":\"Белый\"\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleRemoveUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        String id = unicornRequests.createUnicorn("{\n" +
                "    \"name\": \"Белка\",\n" +
                "    \"tailColor\":\"Белый\"\n" +
                "}");

        unicornRequests.getUnicorn(id, 200);

        unicornRequests.removeUnicorn(id);

        unicornRequests.getUnicorn(id, 404);
    }

    @Test
    public void userShouldBeAbleChangeUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        String id = unicornRequests.createUnicorn("{\n" +
                "    \"name\": \"Белка\",\n" +
                "    \"tailColor\":\"Белый\"\n" +
                "}");

        unicornRequests.getUnicorn(id, 200);

        unicornRequests.changeUnicorn(id, "{\n" +
                "    \"name\": \"Белка\",\n" +
                "    \"tailColor\":\"Красный\"\n" +
                "}");

        String color = unicornRequests.getUnicorn(id, 200);
        Assertions.assertEquals("Красный", color, "Цвет не соответствует ожидаемому");
    }
}
