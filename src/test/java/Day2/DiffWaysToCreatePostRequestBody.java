package Day2; 

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;



/*
 * Different ways to create POST request body
 * 1)-> POST request body using Hashmap
 * 2)-> POST request body creation using Org.Json
 * 3)-> POST request body creation using POJO(Plain Old Java Object) class
 * 4)-> POST request using external json file data 
 * */

public class DiffWaysToCreatePostRequestBody {
	
	// 1)-> POST request body using Hashmap
	
	//@Test(priority  = 1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "Pankaj");
		data.put("location", "india");
		data.put("phone", "123456");
		
		String courseArr[] = {"C", "C++"};
		data.put("courses", courseArr);
		
		given().
		contentType("application/json").
		body(data).
		
		when().
		post("http://localhost:3000/student").
		
		then().
		statusCode(201).
		body("name", equalTo("Pankaj")).
		body("location", equalTo("india")).
		body("phone", equalTo("123456")).
		body("courses[0]", equalTo("C")).
		body("courses[1]", equalTo("C++")).
		header("Content-Type", "application/json; charset=utf-8").
		log().all();
}
	
	// 2)-> POST request body using org.json library
	
		//@Test(priority  = 1)
		void testPostUsingJsonLibrary() {
			
			JSONObject data = new JSONObject();
			data.put("name", "Pankaj");
			data.put("location", "india");
			data.put("phone", "123456");
			
			String courseArr[] = {"C", "C++"};
			data.put("courses", courseArr);
			
			given().
			contentType("application/json").
			body(data.toString()).
			
			when().
			post("http://localhost:3000/student").
			
			then().
			statusCode(201).
			body("name", equalTo("Pankaj")).
			body("location", equalTo("india")).
			body("phone", equalTo("123456")).
			body("courses[0]", equalTo("C")).
			body("courses[1]", equalTo("C++")).
			header("Content-Type", "application/json; charset=utf-8").
			log().all();
	}
		
		// 3)-> POST request body using POJO class
		
			//@Test(priority  = 1)
			void testPostUsingPOJO() {
				
				POJO_PostRequest data = new POJO_PostRequest();
				
				data.setName("Pankaj");
				data.setLocation("india");
				data.setPhone("123456");
				
				String courseArr[] = {"C", "C++"};
				data.setCourses(courseArr);
				
				given().
				contentType("application/json").
				body(data).
				
				when().
				post("http://localhost:3000/student").
				
				then().
				statusCode(201).
				body("name", equalTo("Pankaj")).
				body("location", equalTo("india")).
				body("phone", equalTo("123456")).
				body("courses[0]", equalTo("C")).
				body("courses[1]", equalTo("C++")).
				header("Content-Type", "application/json; charset=utf-8").
				log().all();
		}
			
			// 4)-> POST request body using External JSON file
			
				@Test(priority  = 1)
				void testPostUsingExternalJsonFile() throws FileNotFoundException {
					
					File f = new File(".//body.json");
					
					FileReader fr = new FileReader(f);
					
					JSONTokener jt = new JSONTokener(fr);
					
					JSONObject data = new JSONObject(jt);
					
					given().
					contentType("application/json").
					body(data.toString()).
					
					when().
					post("http://localhost:3000/student").
					
					then().
					statusCode(201).
					body("name", equalTo("Pankaj")).
					body("location", equalTo("india")).
					body("phone", equalTo("123456")).
					body("courses[0]", equalTo("C")).
					body("courses[1]", equalTo("C++")).
					header("Content-Type", "application/json; charset=utf-8").
					log().all();
			}
	
		
	@Test(priority = 2)
	void testDelete() {
		
		given().
		
		when().
		delete("http://localhost:3000/student/4").
		
		then().
		statusCode(200);
	}

}
