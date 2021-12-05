package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleGetTest {
    public static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);
    @Test
    public void getAllUsers(){
        LOGGER.info("----------------API Test: Get All Users --------------");
        //listed out end points
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //using http get method to make request
        Response response =  httpRequest.request(Method.GET);
        LOGGER.debug(response.prettyPrint());
        //validating result is ok and match with response code 200
        Assert.assertEquals(response.getStatusCode(), 200);
        //using jsonPath--this is help to go inside the file format system
        JsonPath jsonPath = response.jsonPath();
        //creating list and by jsonpath.get capture all email from response body
        List <String> listEmails =  jsonPath.get("data.email");
        //expected result/email id is "george.bluth@reqres.in"
        String expectedEmail = "george.bluth@reqres.in";
        //create boolean variable which return expected email from list
        boolean emailExist = listEmails.contains(expectedEmail);
        //validation the actual result is shows, if ture is validated
        Assert.assertTrue(emailExist, expectedEmail + "Does not exist");
        LOGGER.info("---------End Test Case----------");




    }

}
