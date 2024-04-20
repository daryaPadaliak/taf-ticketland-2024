package by.itacademy.padaliak.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TicketlandTest {
    @Test
    public void testGetTicketland() {
        given().
                when().
                get("https://www.ticketland.ru/").
                then().
                statusCode(200);
    }
}
