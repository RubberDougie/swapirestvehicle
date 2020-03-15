package swapirestvehicle;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
//import static io.restassured.module.jsv.JsonSchemaValidator.*;

// https://swapi.co/api/vehicles/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import io.restassured.http.ContentType;

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

}