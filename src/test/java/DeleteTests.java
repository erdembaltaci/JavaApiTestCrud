import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class DeleteTests {
    @Test
    public void test_DeleteAccount() {
        // Not: Burada daha önce oluşturulmuş veya mevcut bir ID'yi (örneğin 4) seçmelisin
        String endpoint = "https://6a06eb14c83ba8ad9b3e2406.mockapi.io/accounts/accounts/1";

        Response response = given().when().delete(endpoint);

        // Kontroller
        response.then().statusCode(200);

        System.out.println("========== DELETE TEST RAPORU ==========");
        System.out.println("Durum Kodu (Status): " + response.getStatusCode());
        System.out.println("Yanıt Süresi: " + response.getTime() + " ms");
        System.out.println("Silme İşlemi Başarıyla Gerçekleşti.");
        System.out.println("========================================");
    }
}