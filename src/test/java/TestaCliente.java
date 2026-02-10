import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TestaCliente {

    String enderecoApiCliente = "http://localhost:8080/";
    String endpointCliente = "cliente";

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

    @Test
    @DisplayName("Quando eu cadastrar um cliente, então ele deve retornar no resultado.")
    public void cadastraCliente(){

        String clienteParaCadastrar = "{\n" +
                "  \"id\": 100,\n" +
                "  \"idade\": 28,\n" +
                "  \"nome\": \"Nathaly\",\n" +
                "  \"risco\": 0\n" +
                "}";

        String respostaEsperadaPost = "{\"100\":{\"nome\":\"Nathaly\",\"idade\":28,\"id\":100,\"risco\":0}}";

        given()
                .contentType(ContentType.JSON)
                .body(clienteParaCadastrar)
        .when()
                .post(enderecoApiCliente+endpointCliente)
        .then()
                .statusCode(201)
                .assertThat().body(containsString(respostaEsperadaPost));

    }

    @Test
    @DisplayName("Quando eu atualizar um cliente, então deve retornar a lista atualizada.")
    public void atualizaCliente() {
        String clienteAtualizado = "{\n" +
                "  \"id\": 100,\n" +
                "  \"idade\": 30,\n" +
                "  \"nome\": \"Nathaly Atualizada\",\n" +
                "  \"risco\": 0\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(clienteAtualizado)
        .when()
                .put(enderecoApiCliente + endpointCliente)
        .then()
                .statusCode(200)
                .assertThat().body(containsString("\"nome\":\"Nathaly Atualizada\""));
    }

    @Test
    @DisplayName("Quando eu deletar um cliente, então deve retornar OK.")
    public void deletaCliente() {
        int id = 100;

        given()
        .when()
                .delete(enderecoApiCliente + endpointCliente + "/" + id)
        .then()
                .statusCode(200);
    }


}
