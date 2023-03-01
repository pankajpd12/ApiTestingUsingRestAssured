package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test(priority = 1)
	void testLogs() {
		
		given().
		
		when().
		get("https://reqres.in/api/users?page=2").
		
		then().
		
		// log().body();        # Prints only Body	
		// log().cookies();     # Print only Cookies
		// log().headers();     # Prints only Headers
		log().all();            // Prints everything including Body, Cookies, Headers etc.
	}

}
