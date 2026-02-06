import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class TestaCliente {

    String enderecoApiCliente = "http://localhost:8080/";

    @Test
    @DisplayName("Quando pegar todos os cliente sem cadastrar, entao a lista deve estar vazia")
    public void pegaTodosClientes () {

        String respostaEsperada = "{}";

        given()
                .contentType(ContentType.JSON)
        .when()
                .get(enderecoApiCliente)
        .then()
                .statusCode(200)
                .assertThat().body(new IsEqual<>(respostaEsperada));


    }
}
