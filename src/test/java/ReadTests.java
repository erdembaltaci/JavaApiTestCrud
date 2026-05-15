import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReadTests {
    @Test
    public void test_GetAccountDetails() {
        String endpoint = "https://6a06eb14c83ba8ad9b3e2406.mockapi.io/accounts/accounts/1";

        Response response = given().when().get(endpoint);

        // Kontroller
        response.then().statusCode(200).body("id", equalTo("1"));

        System.out.println("========== GET TEST RAPORU ==========");
        System.out.println("Durum Kodu (Status): " + response.getStatusCode());
        System.out.println("Yanıt Süresi: " + response.getTime() + " ms");
        System.out.println("Hesap Detayları (JSON):");
        System.out.println(response.getBody().asPrettyString());
        System.out.println("=====================================");
    }
}