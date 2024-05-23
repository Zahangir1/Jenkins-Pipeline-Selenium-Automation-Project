package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAPIAutomation {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in"; // Set the base URI
    }

    @Test(priority = 1)
    public void valid_signup () {
        JSONObject request = new JSONObject();

        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");

        RestAssured.
                given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/api/register").
                then().
                statusCode(200).
                body("token", equalTo("QpwL5tke4Pnpja7X4")).
                body("id", equalTo(4));

    }

    @Test (priority = 2)
    public void wrong_credential () {
        JSONObject request = new JSONObject();

        request.put("email", "ash.holt@reqres.in");
        request.put("password", "pistol");

        RestAssured.
                given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/api/register").
                then().
                statusCode(400).
                body("error", equalTo("Note: Only defined users succeed registration"));

    }

    @Test (priority = 3)
    public void signup_onlyEmail () {
        JSONObject request = new JSONObject();

        request.put("email", "eve.holt@reqres.in");

        RestAssured.
                given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/api/register").
                then().
                statusCode(400).
                body("error", equalTo("Missing password"));

    }

    @Test (priority = 4)
    public void signup_onlyPassword () {
        JSONObject request = new JSONObject();

        request.put("password", "pistol");

        RestAssured.
                given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).

                when().
                post("/api/register").
                then().
                statusCode(400).
                body("error", equalTo("Missing email or username"));
    }

    @AfterClass
    public void afterTest() {
        //Reset Values
        RestAssured.reset();
    }


}
