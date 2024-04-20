package by.itacademy.padaliak.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SearchTest {
    @Test
    @DisplayName("Search 'золушка'")
    public void testSearchTicketland(){
        given().
                queryParam("text","%D0%B7%D0%BE%D0%BB%D1%83%D1%88%D0%BA%D0%B0").
                when().get("https://www.ticketland.ru/children/").
                then().assertThat().statusCode(200);
    }
}
