package Rest;

import io.restassured.response.Response;

public class StellarBurgersApi extends BaseHttpClient{
    private String pathDeleteUser = "/api/auth/user";
    private String pathLogin = "/api/auth/login";

    public Response doPostLogin(String body){
        return doPostRequest(pathLogin, body);
    }

    public Response doDeleteUser(String token){
        return doDeleteRequest(pathDeleteUser, token);
    }

}
