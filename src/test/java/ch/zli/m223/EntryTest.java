package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class EntryTest {

    //jwt von quarkus.io/guides/security-jwt
    String admin = "eyJraWQiOiJcL3ByaXZhdGVLZXkucGVtIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJqZG9lLXVzaW5nLWp3dC1yYmFjIiwiYXVkIjoidXNpbmctand0LXJiYWMiLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJiaXJ0aGRhdGUiOiIyMDAxLTA3LTEzIiwiYXV0aF90aW1lIjoxNTUxNjU5Njc2LCJpc3MiOiJodHRwczpcL1wvcXVhcmt1cy5pb1wvdXNpbmctand0LXJiYWMiLCJyb2xlTWFwcGluZ3MiOnsiZ3JvdXAyIjoiR3JvdXAyTWFwcGVkUm9sZSIsImdyb3VwMSI6Ikdyb3VwMU1hcHBlZFJvbGUifSwiZ3JvdXBzIjpbIkVjaG9lciIsIlRlc3RlciIsIlN1YnNjcmliZXIiLCJncm91cDIiXSwicHJlZmVycmVkX3VzZXJuYW1lIjoiamRvZSIsImV4cCI6MTU1MTY1OTk3NiwiaWF0IjoxNTUxNjU5Njc2LCJqdGkiOiJhLTEyMyJ9.O9tx_wNNS4qdpFhxeD1e7v4aBNWz1FCq0UV8qmXd7dW9xM4hA5TO-ZREk3ApMrL7_rnX8z81qGPIo_R8IfHDyNaI1SLD56gVX-NaOLS2OjfcbO3zOWJPKR_BoZkYACtMoqlWgIwIRC-wJKUJU025dHZiNL0FWO4PjwuCz8hpZYXIuRscfFhXKrDX1fh3jDhTsOEFfu67ACd85f3BdX9pe-ayKSVLh_RSbTbBPeyoYPE59FW7H5-i8IE-Gqu838Hz0i38ksEJFI25eR-AJ6_PSUD0_-TV3NjXhF3bFIeT4VSaIZcpibekoJg0cQm-4ApPEcPLdgTejYHA-mupb8hSwg";
    String benutzer = "eyJraWQiOiJcL3ByaXZhdGVLZXkucGVtIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJqZG9lLXVzaW5nLWp3dC1yYmFjIiwiYXVkIjoidXNpbmctand0LXJiYWMiLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJiaXJ0aGRhdGUiOiIyMDAxLTA3LTEzIiwiYXV0aF90aW1lIjoxNTUxNjU5Njc2LCJpc3MiOiJodHRwczpcL1wvcXVhcmt1cy5pb1wvdXNpbmctand0LXJiYWMiLCJyb2xlTWFwcGluZ3MiOnsiZ3JvdXAyIjoiR3JvdXAyTWFwcGVkUm9sZSIsImdyb3VwMSI6Ikdyb3VwMU1hcHBlZFJvbGUifSwiZ3JvdXBzIjpbIkVjaG9lciIsIlRlc3RlciIsIlN1YnNjcmliZXIiLCJncm91cDIiXSwicHJlZmVycmVkX3VzZXJuYW1lIjoiamRvZSIsImV4cCI6MTU1MTY1OTk3NiwiaWF0IjoxNTUxNjU5Njc2LCJqdGkiOiJhLTEyMyJ9.O9tx_wNNS4qdpFhxeD1e7v4aBNWz1FCq0UV8qmXd7dW9xM4hA5TO-ZREk3ApMrL7_rnX8z81qGPIo_R8IfHDyNaI1SLD56gVX-NaOLS2OjfcbO3zOWJPKR_BoZkYACtMoqlWgIwIRC-wJKUJU025dHZiNL0FWO4PjwuCz8hpZYXIuRscfFhXKrDX1fh3jDhTsOEFfu67ACd85f3BdX9pe-ayKSVLh_RSbTbBPeyoYPE59FW7H5-i8IE-Gqu838Hz0i38ksEJFI25eR-AJ6_PSUD0_-TV3NjXhF3bFIeT4VSaIZcpibekoJg0cQm-4ApPEcPLdgTejYHA-mupb8hSwg";

    @Test
    //fail
    public void testCreateEntry(){
        given()
        .auth().oauth2(admin)
        .auth().oauth2(benutzer)
            .when().post("/entri")
            .then()
                .statusCode(500);
    }

    @Test
    //fail
    public void testDeleteEntry(){
        given()
            .auth().oauth2(benutzer)
            .when().delete("/entries/1")
            .then()
                .statusCode(403);
    }

    @Test
    //success
    public void testUpdateEntry(){
        given()
            .when().put("/entries/2")
            .then()
                .statusCode(200);
    }
    
}
