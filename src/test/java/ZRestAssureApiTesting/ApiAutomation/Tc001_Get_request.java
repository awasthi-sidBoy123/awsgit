package ZRestAssureApiTesting.ApiAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc001_Get_request {

	@Test
	 void getWeatherDetails() {
		
		//First specify base url
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 
		 //then specify request object
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 //specify response object
		 Response response = httpRequest.request(Method.GET	, "/Hyderabad");
		 //To get response body
		 String responseBody = response.getBody().asString();
		 System.out.println("Response body is "+responseBody);
		 
		 //status code validation
		 int statusCode =  response.getStatusCode();
		 System.out.println("Status code is "+statusCode);
		 
		 
		 String statusLine = response.getStatusLine();
		 System.out.println("response status line is "+statusLine);
		 		
	}
	
	
}
