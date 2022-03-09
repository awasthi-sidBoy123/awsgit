package mockJson;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import stringfiles.FileOfStrings;

public class DemoJson {
	
	@Test
	public void checkParsing() {
		
		JsonPath js = new JsonPath(FileOfStrings.demoBody());
		String data = js.getString("courses");
		int size = js.getInt("courses.size()");
		System.out.println("size is "+size);
		System.out.println("data is "+data);
		int pAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("amount is "+pAmount);
		String getTitle = js.get("courses[0].title");
		System.out.println("getTitle is "+getTitle);
		
		int price = 0;
		int total = 0 ;
		
		for (int i=0;i<size;i++) {
			String title = js.get("courses["+i+"].title");
			System.out.println("Title is "+title);
		
			if (title.equalsIgnoreCase("Cypress")) {
				price = price + js.getInt("courses["+i+"].price");
				System.out.println("Price is "+price);
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("copies "+copies);
				break;
			}
		}
		
//		for (int i=0;i<size;i++) {
//			String title = js.get("courses["+i+"].title");
//			System.out.println("Title is "+title);
//			price = price + js.getInt("courses["+i+"].price");
//			total = price;
//			System.out.println("Price is "+price);
//			
//			int copies = js.getInt("courses["+i+"].copies");
//			System.out.println("copies "+copies);
//		}
//			System.out.println("total is "+total);	
	}
	
}
