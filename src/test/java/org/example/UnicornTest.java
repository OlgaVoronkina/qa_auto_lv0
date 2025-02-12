package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class UnicornTest {
    @BeforeAll
    public static void setupTests(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://crudcrud.com/api/de49edaa52924e1682be647b79f6c244";
    }
    @Test
    public void userShouldBeAbleCreateUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        Unicorn unicorn = Unicorn.builder()
                .name("Белка")
                .tailColor("Белый")
                .build();
        unicornRequests.createUnicorn(unicorn);
    }

    @Test
    public void userShouldBeAbleRemoveUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        Unicorn unicorn = Unicorn.builder()
                .name("Белка")
                .tailColor("Белый")
                .build();
        Unicorn createdUnicorn = unicornRequests.createUnicorn(unicorn);

        unicornRequests.getUnicorn(createdUnicorn.getId(), 200);

        unicornRequests.removeUnicorn(createdUnicorn.getId());

        unicornRequests.getUnicorn(createdUnicorn.getId(), 404);
    }

    @Test
    public void userShouldBeAbleChangeUnicorn(){
        UnicornRequests unicornRequests = new UnicornRequests();
        Unicorn unicorn1 = Unicorn.builder()
                .name("Белка")
                .tailColor("Белый")
                .build();
        Unicorn createdUnicorn = unicornRequests.createUnicorn(unicorn1);

        unicornRequests.getUnicorn(createdUnicorn.getId(), 200);

        Unicorn unicorn2 = Unicorn.builder()
                .name("Белка")
                .tailColor("Красный")
                .build();
        unicornRequests.changeUnicorn(createdUnicorn.getId(), unicorn2);

        Unicorn unicorn = unicornRequests.getUnicorn(createdUnicorn.getId(), 200);
        Assertions.assertEquals("Красный", unicorn.getTailColor(), "Цвет не соответствует ожидаемому");
    }
}
