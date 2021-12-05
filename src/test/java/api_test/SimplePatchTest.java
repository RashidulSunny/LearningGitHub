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

public class SimplePatchTest {
    public static final Logger LOGGER = LogManager.getLogger(SimplePatchTest.class);
    @Test
    public void updateUserSingleField(){
        LOGGER.info("----------------API Test: Update Users Single Field jobTitle--------------");
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //generated random data by faker library
        Faker faker = new Faker();
        //build request body
        String jobTitle = faker.job().title();
        LOGGER.debug("New User Job Title: " + jobTitle);
        //put request body to key

        JSONObject requestBody = new JSONObject();

        requestBody.put("job",jobTitle);
        //declare body type is json by using header

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestBody.toJSONString());
        //create post method for creating new user
        String id = "2";
        Response response = httpRequest.request(Method.PATCH,id);
        LOGGER.debug(response.prettyPrint());
        //validate response code 201
        Assert.assertEquals(response.getStatusCode(), 200);
        //creating object jsonPath
        JsonPath jsonPath = response.jsonPath();
        String actualJob = jsonPath.getString("job");
        //validate actual name is match with expected name
        Assert.assertEquals(actualJob,jobTitle);

        LOGGER.info("---------End Test Case----------");

    }

}
