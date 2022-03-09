package ZRestAssureApiTesting.ApiAutomation;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc002_post {
	
	
	public void postRequest() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject jsonrequest = new JSONObject();
		jsonrequest.put("firstname", "John");
		jsonrequest.put("lastname", "John");
		jsonrequest.put("username", "John");
		jsonrequest.put("password", "John");
		jsonrequest.put("email", "John@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonrequest.toJSONString());
		Response response = httpRequest.request(Method.POST,"/register");
		
		 int statusCode =  response.getStatusCode();
		 System.out.println("Status code is "+statusCode);
		 
		 
		 String statusLine = response.getStatusLine();
		 System.out.println("response status line is "+statusLine);
		 
		 
		 String sucessCode = response.jsonPath().get("SucessCode");
		
		
		
		
	}
	
	

}
