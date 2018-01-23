package api.bagels.cmb.tests;



import api.bagels.cmb.beans.Bagel;
import api.bagels.cmb.beans.Bagels;
import api.bagels.cmb.util.RestHelper;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CMBBagelsGETRequests {

	//Simple GET Request to check API up and running
	@Test
	public void noParamsStatusCodeTest(){
		
		given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.when().get(RestHelper.getUri())
		.then().assertThat().statusCode(200);

	}
	//checking respond without params
	@Test
	public void noParamsFieldsTest(){
		
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.when().get(RestHelper.getUri());
		
		String[] expectedFields = {"id","name","age","gender","locations","coordinates"};
		for (String field : expectedFields) {
			assertTrue(field + " test",response.body().asString().contains(field));
		}

	}

	//checking httpStatusCode with params
	@Test
	public void allParamsGetStatusCodeTest(){
		//creating parameters
		Map<String, String> params = new HashMap<>();
		params.put("dist", "100");
		params.put("origin","37.774929,-122.419417");
		params.put("min_age", "4");
		params.put("max_age","100");
		params.put("limit", "10");
		params.put("offset", "0");
		
			
		given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().params(params)
		.and().accept(ContentType.JSON)
		.when().get(RestHelper.getUri())
		.then().assertThat().statusCode(200);
	}
	//checking Gender filter
	@Test
	public void genderParamTest(){
		
		Map<String, String> params = new HashMap<>();
		params.put("gender", "m");
		
			
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().params(params)
		.and().accept(ContentType.JSON)
		.when().get(RestHelper.getUri());
		
		assertEquals(200,response.statusCode());
		
	}
	//checking name filter
	@Test
	public void nameParamTest(){
		
		Map<String, String> params = new HashMap<>();
		params.put("name", "Peter");
		
			
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().params(params)
		.and().accept(ContentType.JSON)
		.when().get(RestHelper.getUri());
		
		assertEquals(200,response.statusCode());
		
		List<String> names = response.body().jsonPath().getList("name");
		
		for (String name : names) {
			assertTrue(name.contains("Peter"));
		}
		
	}
}
