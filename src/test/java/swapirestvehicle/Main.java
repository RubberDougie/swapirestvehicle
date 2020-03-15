package swapirestvehicle;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Execution(ExecutionMode.CONCURRENT)
public class Main {

	/*
	 * @BeforeAll public void commonSetUp() { // }
	 */

	@Test
	public void firstTest() {
		given().baseUri("https://swapi.co/api").contentType(ContentType.JSON).when().get("/vehicles/4/").then()
				.assertThat().statusCode(200);
	}

	@Test
	public void secondTest() {
		given().baseUri("https://swapi.co/api").contentType(ContentType.JSON).when().get("/vehicles/8/").then()
				.assertThat().statusCode(200);
	}

	@Test
	public void testKnownResponseContents() {
		Response response = given().when().get("https://swapi.co/api/vehicles/4/");
		String name = response.jsonPath().get("name");
		assertEquals("Sand Crawler", name);
	}

	@Test
	public void testPageNotFound() {
		given().baseUri("https://swapi.co/api").contentType(ContentType.JSON).when().get("/vehicles/gsdfg/").then()
				.assertThat().statusCode(404);
	}
}