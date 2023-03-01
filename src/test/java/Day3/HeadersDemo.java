package Day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HeadersDemo {
	
	//@Test(priority=1)
		void testHeaders() {
			
			given().
			
			when().
			get("https://www.google.com/").
			
			then().
			header("Content-Type", "text/html; charset=ISO-8859-1").
			and().
			header("Content-Encoding", "gzip").
			and().
			header("Server", "gws");
		}
		
		@Test(priority = 2)
		void getHeaders() {
			
			Response res = given().
			
			when().
			get("https://www.google.com/");
			
			
			// get single header info
			
			String header_value = res.getHeader("Content-Type");
			System.out.println("The value of Content-Type header is : "+header_value);
			
			// get all headers info
			
			Headers my_headers = res.getHeaders();
			
			for(Header hd:my_headers) {
				System.out.println(hd.getName()+"      "+hd.getValue());
			}
			
		}	

}
