package deserialization;

import io.restassured.RestAssured;
import stringfiles.FileOfStrings;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.apache.batik.util.gui.LocationBar;
import org.testng.annotations.Test;

public class Des {

	@Test
	public static void deserialization() {
		
		
		BodyParam bp = new BodyParam();
		bp.setAccuracy(50);
		bp.setPhone_number("(+91) 983 893 3937");
		bp.setName("Frontline house");
		Location locc = new Location();
		locc.setLat(-38.383494);
		locc.setLng(33.427362);
		bp.setLocation(locc);
		bp.setLanguage("French-IN");
		List<String> typ = new ArrayList<String>();
		typ.add("shoe park");
		typ.add("shop");
		bp.setTypes(typ);
		
		RestAssured.baseURI  = "https://rahulshettyacademy.com";
		String res = given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(bp).log().all()
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
	    	System.out.println(res);
		
	}
	
}
 