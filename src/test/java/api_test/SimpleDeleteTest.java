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

public class SimpleDeleteTest {
    public static final Logger LOGGER = LogManager.getLogger(SimpleDeleteTest.class);

    @Test
    public void getSingleUser() {
        LOGGER.info("----------------API Test: Delete Single User With Path Variables --------------");
        //listed out end points
        RestAssured.baseURI = "https://reqres.in/api/users";
        //create request object to make the request
        RequestSpecification httpRequest = RestAssured.given();
        //using http get method with String variable id to make request
        String id = "2";
        Response response = httpRequest.request(Method.DELETE, id);
        LOGGER.debug(response.prettyPrint());
        //validating result is ok and match with response code 200
        Assert.assertEquals(response.getStatusCode(), 204);


        LOGGER.info("---------End Test Case----------");

    }
}
