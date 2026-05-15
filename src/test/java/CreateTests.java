import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateTests {
    @Test
    public void test_CreateNewAccount() {
        String endpoint = "https://6a06eb14c83ba8ad9b3e2406.mockapi.io/accounts/accounts";

        String accountBody = "{\n" +
                "    \"name\": \"Ali Erdem Baltaci\",\n" +
                "    \"avatar\": \"erdem_profile_img.jpg\"\n" +
                "}";

        // Tüm cevabı (Response) bir değişkene alıyoruz
        Response response = given()
                .contentType(ContentType.JSON)
                .body(accountBody)
                .when()
                .post(endpoint);

        // Kontrollerimizi yapıyoruz (Assertion)
        response.then().statusCode(201).body("name", equalTo("Ali Erdem Baltaci"));

        // Konsola şık bir rapor yazdırıyoruz
        System.out.println("========== TEST RAPORU ==========");
        System.out.println("Durum Kodu (Status): " + response.getStatusCode());
        System.out.println("Yanıt Süresi: " + response.getTime() + " ms");
        System.out.println("Gelen Veri (JSON):");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("=================================");
    }
}