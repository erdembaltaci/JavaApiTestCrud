import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdateTests {
    @Test
    public void test_UpdateAccount() {
        String endpoint = "https://6a06eb14c83ba8ad9b3e2406.mockapi.io/accounts/accounts/1";

        // Gönderilen veri
        String nameValue = "Updated fvrf Ali Erdem";
        String updateBody = "{\"name\": \"" + nameValue + "\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(updateBody)
                .when()
                .patch(endpoint); // Teknik doğruluk için PATCH yaptık

        // Kontroller - nameValue değişkenini kullanarak hata riskini sıfırladık
        response.then()
                .statusCode(200)
                .body("name", equalTo(nameValue));

        System.out.println("========== PATCH TEST RAPORU ==========");
        System.out.println("Durum Kodu (Status): " + response.getStatusCode());
        System.out.println("Yanıt Süresi: " + response.getTime() + " ms");
        System.out.println("Güncellenmiş Veri (JSON):");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("=======================================");
    }
}