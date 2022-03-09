package ZRestAssureApiTesting.ApiAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JiraRestApi {
	
	SessionFilter session = new SessionFilter();
	@Test
	public void jiraRestApi() {
		
		
		RestAssured.baseURI = "http://localhost:8081/";
		String logInRespo = given().header("Content-Type","application/json").body("{ \"username\": \"siddharth.sidh007\","
				+ " \"password\": \"Sid@jira_2021\" }").log().all().filter(session).post("/rest/auth/1/session").then().log().all().extract().response().asString();
		
		
		//Mark: - Alias 
//		String loInRespo = given().header("Content-Type","application/json").body("{ \"username\": \"siddharth.sidh007\","
//				+ " \"password\": \"Sid@jira_2021\" }").log().all().post("/rest/auth/1/session").then().log().all().extract().response().asString();
//		JsonPath js = new JsonPath(loInRespo);
//		Syring 
		
		
		
		 given().pathParam("key", "10102").log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \"This is a debit card bug updated by add comment.\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post(" /rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201);
		
		
		
		//given().pathParam("key", "10102").log().all().header("X-Atlassian-Token" , "no-check").filter(session).pathParam("key", "10102")
		//.multiPart("file", new File("jira.txt")).when().post(" ").then().log().all().assertThat().statusCode(200);
	}
	
	

	

}
