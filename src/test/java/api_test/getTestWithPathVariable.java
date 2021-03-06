package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class getTestWithPathVariable extends BaseClassApiTest{

    @Test
    public void getSingleUser(){
        LOGGER.info(testCaseName);
        //listed out end points
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //using http get method with String variable id to make request
        String id = "2";
        Response response =  httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());
        //validating result is ok and match with response code 200
        Assert.assertEquals(response.getStatusCode(), 200);
        //using jsonPath--this is help to go inside the file format system
        JsonPath jsonPath = response.jsonPath();
        //creating String variable and by jsonpath.get capture single email from response body
        String actualEmail =  jsonPath.getString("data.email");
        //expected result/email id is "janet.weaver@reqres.in"
        String expectedEmail = "janet.weaver@reqres.in";
        Assert.assertEquals(actualEmail,expectedEmail);

        LOGGER.info(endTestCase);

    }

    @Test
    public void attemptToGetUserWithInvalidId(){
        LOGGER.info(testCaseName);
        //listed out end points
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //using http get method with String variable id to make request
        String id = "23";
        Response response =  httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());
        //validating result is ok and match with response code 200
        Assert.assertEquals(response.getStatusCode(), 404);
        //using jsonPath--this is help to go inside the file format system
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get().toString(),"{}");

        LOGGER.info(endTestCase);


    }

}
