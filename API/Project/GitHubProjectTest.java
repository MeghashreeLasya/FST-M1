package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest {
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHx9f/I8EjfoBqUImQT1beXyr0lKkHksjq0KKCBN8PSO";

    int sshKeyId;

    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization","token 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").
            addHeader("Content-Type","application/json").
            build();

    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).
            expectBody("key",equalTo(sshKey)).
            expectBody("title",equalTo("TestAPIKey")).
            build();

    @Test(priority = 1)
    public void postRequestTest()
    {
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        Response response = given().log().all().spec(requestSpec).body(reqBody).when().post();
        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);
        Reporter.log(response.getBody().asPrettyString());
        System.out.println(response.getBody().asPrettyString());

    }

    @Test(priority = 2)
    public void getRequestTest()
    {
        Response response =
                given().log().all().spec(requestSpec).pathParam("keyId",sshKeyId).
                when().get("/{keyId}");
        response.then().statusCode(200).spec(responseSpec);
        Reporter.log(response.getBody().asPrettyString());
        System.out.println(response.getBody().asPrettyString());

    }

    @Test(priority = 3)
    public void deleteRequestTest()
    {
        given().log().all().spec(requestSpec).pathParam("keyId",sshKeyId).
                when().delete("/{keyId}").then().statusCode(204).time(lessThan(3000L));


    }
}
