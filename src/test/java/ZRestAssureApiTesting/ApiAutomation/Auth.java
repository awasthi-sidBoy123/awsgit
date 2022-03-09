package ZRestAssureApiTesting.ApiAutomation;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import reusable.ReusableMethods;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POJO.GetSet;
import POJO.GetWebAuto;


public class Auth {

	@Test
	public void authTesting() {
		
//		System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("awasthisidboy123@gmail.com");
//		driver.findElement(By.xpath("//div[@id='identifierNext']/div")).click();
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123@qwe123");
//		driver.findElement(By.xpath("//div[@id='passwordNext']/div/button")).click();
		
		
		
		RestAssured.baseURI = "";
		
		
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AY0e-g79Uoqryfix9ahwTbcqQd3MNAUbDU22-NDOpKa9lc3BEkPV9kBE79oCr5WA7nHyug&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent#";
	    String getSplit = url.split("code=")[1];
	    String getCode = getSplit.split("&scope")[0];
		
		String respo = given().log().all().urlEncodingEnabled(false)
		.queryParam("code", getCode)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_url", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.queryParam("state","verifyfjdss")
		.queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
	    .queryParam("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
		.when().post().then().log().all().extract().response().asString();
		
		JsonPath js = ReusableMethods.jsonPaths(respo);
		String acessToken = js.get("accessToken");
		
		
		//Mark:- to get response add access token
		//Mark:- Default parser because we are parsing json to get values
		GetSet gc = given().log().all().queryParam("accessToken", acessToken).expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetSet.class);

		String instruct = gc.getdashboard();
		System.out.println(instruct);
		gc.getcourses().getApi().size();
		List<GetWebAuto> autoCourses = gc.getcourses().getWebAutomation();
		
		for(int i=0;i<autoCourses.size();i++) {
			if(autoCourses.get(i).getTitle().equalsIgnoreCase("Selenium")) {
				String a = autoCourses.get(i).getTitle();
				System.out.println(a);
			}
		}
		
		

	}
}
