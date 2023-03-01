package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class PathAndQueryParameters {
	
	@Test
	void testQueryAndPathParameters() {
		
		given().
	//	pathParam("myPath1", "api").    //path parameters   (Optional)
		pathParam("myPath", "users").    //path parameters
		queryParam("page", 2).          //query parameters
		queryParam("id", 5).           //query parameters
		
		when().
		get("https://reqres.in/api/{myPath}").
		
		then().
		statusCode(200).
		log().all();
		
	}

}
