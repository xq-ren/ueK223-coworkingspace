package ch.zli.m223;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AppUserTest {

	@Test
    //success
    public void testUserList(){
        given()
            .when().get("/users")
            .then()
                .statusCode(200);
    }

    @Test
    //success
    public void testDeleteUser(){
        given()
            .when().delete("/user/2")
            .then()
                .statusCode(200);


    }

    @Test
    //fail
    public void testgetUserById(){
        given()
            .when().get("/users/100")
            .then()
                .statusCode(401);
    }

	
    
}
