package ZRestAssureApiTesting.ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reusable.ReusableMethods;
import stringfiles.FileOfStrings;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LibraryApiTest {
	
	@Test(dataProvider="sendData")
	public void libApi(String isbn , String aisle) {
		//Mark:- Staticly adding isbn and aisle
		
		RestAssured.baseURI = "http://216.10.245.166";
//		String postResponse = given().log().all().header("Content-Type","application/json").body(FileOfStrings.libPost()).post("/Library/Addbook.php")
//		.then().assertThat().statusCode(200).extract().response().asString();
//		
//		JsonPath js = ReusableMethods.jsonPaths(postResponse);
//		String getID = js.get("ID");
//		System.out.println("ID is "+getID);
		
		//Mark:- Dynamically adding isbn and aisle
		
		String respo = given().log().all().header("Content-Type","application/json").body(FileOfStrings.libPost(isbn,aisle)).post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethods.jsonPaths(respo);
		String getID = js.get("ID");
		System.out.println("ID is "+getID);
		
	}
	
	@DataProvider
	public Object[][] sendData(){
		
		Object[][] obj = new Object[1][2];
		
		obj[0][0] = "assd";
		obj[0][1] = "bc1234";
		
		return obj;
		
	}
	
	

}
