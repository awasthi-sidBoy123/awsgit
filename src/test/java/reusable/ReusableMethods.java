package reusable;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath jsonPaths(String response) {
		
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	
}
