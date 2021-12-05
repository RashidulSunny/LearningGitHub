package api_test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePostTest {
    public static final Logger LOGGER = LogManager.getLogger(SimplePostTest.class);
    @Test
    public void createNewUser(){
        LOGGER.info("----------------API Test: Get All Users --------------");
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //generated random data by faker libery
        Faker faker = new Faker();
        //build request body
        String name = faker.name().fullName();
        LOGGER.debug("New User Full Name: " + name);
        String jobTitle = faker.job().title();
        LOGGER.debug("New User Job Title: " + jobTitle);
        //put request body to key

        JSONObject requestBody = new JSONObject();
        requestBody.put("name",name);
        requestBody.put("job",jobTitle);
        //declare body type is json by using header

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestBody.toJSONString());
        //create post method for creating new user
        Response response = httpRequest.request(Method.POST);
        LOGGER.debug(response.prettyPrint());
        //validate response code 201
        Assert.assertEquals(response.getStatusCode(), 201);
        //creating object jsonPath
        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");
        //validate actual name is match with expected name
        Assert.assertEquals(actualName,name);

        LOGGER.info("---------End Test Case----------");

    }

}
