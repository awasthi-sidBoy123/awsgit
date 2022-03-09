package ZRestAssureApiTesting.ApiAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reusable.ReusableMethods;
import stringfiles.FileOfStrings;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class post_request {
	
	
	@Test
	public void post_check() {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
//		given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(FileOfStrings.bodyOfHeader())
//		.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
//		        .header("Connection", "keep-alive");
		
		//Mark:- Now get response in string and convert that in to json
		
	  String response =	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(FileOfStrings.bodyOfHeader())
	   .when().post("maps/api/place/add/json").then()
		        .extract().response().asString();
	  
	  System.out.println("response is "+response);
	  //Mark:- To parse string in json we use JsonPath
	  
	   JsonPath js = new JsonPath(response);
	   String getPlaceId = js.getString("place_id");
	   System.out.println("placeId is "+getPlaceId);
	   
	   
	   
	   //Mark:- Put
	   given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
	   		+ "\"place_id\" : \""+getPlaceId+"\",\r\n"
	   		+ "\"address\"  : \"29 abc side layou, cohen 09\",\r\n"
	   		+ "\"key\"      : \"qaclick123\"\r\n"
	   		+ "}").put("/maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	   
	   String changedAddress = "29 abc side layou, cohen 09";
	   
	   //Mark: Get
	  String getResp =  given().log().all().queryParam("key", "qaclick123")
	   .queryParam("place_id", "7706b9369b275b47e62f04abfa27027a").header("Content-Type","application/json").body("{\r\n"
	   		+ "  \"location\": {\r\n"
	   		+ "    \"lat\": -38.383494,\r\n"
	   		+ "    \"lng\": 33.427362\r\n"
	   		+ "  },\r\n"
	   		+ "  \"accuracy\": 50,\r\n"
	   		+ "  \"name\": \"Frontline house\",\r\n"
	   		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
	   		+ "  \"address\": \""+changedAddress+"\",\r\n"
	   		+ "  \"types\": [\r\n"
	   		+ "    \"shoe park\",\r\n"
	   		+ "    \"shop\"\r\n"
	   		+ "  ],\r\n"
	   		+ "  \"website\": \"http://google.com\",\r\n"
	   		+ "  \"language\": \"French-IN\"\r\n"
	   		+ "}").get("/maps/api/place/get/json").then().statusCode(200).extract().response().asString();
	  
	  System.out.println("GET response is "+getResp);
	  
	  JsonPath jsp =  ReusableMethods.jsonPaths(getResp);
	  String add = jsp.getString("address");
	  System.out.println("adress is "+add);
	  Assert.assertEquals(add,"29 abc side layou, cohen 09" );
	   
	}
	
	
	

}
