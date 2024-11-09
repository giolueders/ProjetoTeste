package projetoAutomacao.teste;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class apiGetTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev"; }

    @Test
    public void testGetUsers() {
        given()
        .when()
            .get("/objects") 
        .then()
            .statusCode(200) // Valida se o status da resposta é 200 (OK)
            .body("$", not(empty())) // Verifica que a lista não está vazia
            .body("name", everyItem(notNullValue()));
    }
    @Test
    public void testGetUserById() {
        String idObject = "1";

        ValidatableResponse response = 
            given()
                .pathParam("id", idObject)
            .when()
                .get("/objects?id={id}") 
            .then()
                .statusCode(200) // Valida se o status da resposta é 200 (OK)
                .body("id[0][0]", equalTo(idObject));

        Response actualResponse = response.extract().response();
        System.out.println("Resposta da API: " + actualResponse.asString());

    }

}


