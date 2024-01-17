package api.test;

import api.step.UserSteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class UserTest {


    private final UserSteps steps = new UserSteps();


    @Test
    void createUser() {

        steps.createUser();
        steps.getUser();
        steps.deleteUser();
        steps.getEmptyUser();

        Response response = RestAssured.get("https://petstore.swagger.io/v2/user/Zodiac");
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("User not found"));

    }

    @Test
  void userDoubleDelete() {
      steps.createUser();
      steps.deleteUser();
      steps.deleteEmptyUser();
        Response response = RestAssured.delete("https://petstore.swagger.io/v2/user/Zodiac");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);


        }
    }

