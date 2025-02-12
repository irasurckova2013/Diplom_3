import Rest.StellarBurgersApi;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class DeleteUserSteps {
    private StellarBurgersApi stellarBurgersApi = new StellarBurgersApi();

    @Step("Логин")
    public Response loginUser () {

        return stellarBurgersApi.doPostLogin("{\"email\":\"" + TestCredentials.EMAIL + "\",\"password\":\"" + TestCredentials.PASSWORD + "\"}");
    }

    @Step("Удаление клиента")
    public Response deleteUser () {
        Response postLogin = loginUser ();

        if (postLogin.getStatusCode() == 200) {
            String token = postLogin.jsonPath().getString("accessToken");
            return stellarBurgersApi.doDeleteUser (token); // Возвращаем результат удаления
        } else {
            throw new RuntimeException("Login failed: " + postLogin.getStatusLine());
        }
    }
}