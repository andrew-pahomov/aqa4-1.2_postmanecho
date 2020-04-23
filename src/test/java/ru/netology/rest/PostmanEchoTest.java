package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class PostmanEchoTest {
    @Test
    void shouldReturnSendData() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("postmanecho.schema.json"))
        ;
    }
}
