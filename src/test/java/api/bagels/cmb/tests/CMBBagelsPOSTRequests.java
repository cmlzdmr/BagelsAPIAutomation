package api.bagels.cmb.tests;

import org.junit.Test;

import api.bagels.cmb.beans.Bagel;
import api.bagels.cmb.beans.Bagels;
import api.bagels.cmb.beans.Location;
import api.bagels.cmb.util.RestHelper;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CMBBagelsPOSTRequests {
	
	@Test
	public void postTest() {
		//Build pojo
		Bagel postBagel = new Bagel();
		postBagel.setName("Chris Jenkins");
		postBagel.setAge(33);
		postBagel.setGender("m");
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("McLean, US", Arrays.asList(-37.9252124 , 144.8277777)));
		postBagel.setLocations(locations);
		
		//send post request
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().body(postBagel)
		.when().post(RestHelper.getUri());
		
		assertEquals(201, response.getStatusCode());
		JsonPath path = response.jsonPath();
		assertTrue(path.getInt("id") > 0);
		assertTrue(path.getString("name").equals("Chris Jenkins"));
		assertEquals(33,path.getInt("age"));
		assertEquals("m",path.getString("gender"));
		assertTrue(path.getList("activity.name").containsAll(Arrays.asList("McLean, US")));
		
	}
	//passing negative age number 
	@Test
	public void postAgeTest() {
		//Build pojo
		Bagel postBagel = new Bagel();
		postBagel.setName("Chris Jenkins");
		postBagel.setAge(-33);
		postBagel.setGender("m");
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("McLean, US", Arrays.asList(-37.9252124 , 144.8277777)));
		postBagel.setLocations(locations);
		
		//send post request
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().body(postBagel)
		.when().post(RestHelper.getUri());
		
		assertEquals(400, response.getStatusCode());
		
	}
	
	//passing numbers as a name 
	@Test
	public void postNameTest() {
		//Build pojo
		Bagel postBagel = new Bagel();
		postBagel.setName("1234567");
		postBagel.setAge(25);
		postBagel.setGender("m");
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("McLean, US", Arrays.asList(-37.9252124 , 144.8277777)));
		postBagel.setLocations(locations);
		
		//send post request
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().body(postBagel)
		.when().post(RestHelper.getUri());
		
		assertEquals(400, response.getStatusCode());
		
	}
	//passing name empty 
		@Test
		public void postNameTestEmpty() {
			//Build pojo
			Bagel postBagel = new Bagel();
			postBagel.setName("");
			postBagel.setAge(25);
			postBagel.setGender("m");
			List<Location> locations = new ArrayList<>();
			locations.add(new Location("McLean, US", Arrays.asList(-37.9252124 , 144.8277777)));
			postBagel.setLocations(locations);
			
			//send post request
			Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
			.and().accept(ContentType.JSON)
			.and().contentType(ContentType.JSON)
			.and().body(postBagel)
			.when().post(RestHelper.getUri());
			//Checking httpStatusCode
			assertEquals(400, response.getStatusCode());
			
		}
	//post Location Name empty 
	@Test
	public void postLocationNameTest() {
		//Build pojo
		Bagel postBagel = new Bagel();
		postBagel.setName("1234567");
		postBagel.setAge(25);
		postBagel.setGender("m");
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("", Arrays.asList(-37.9252124 , 144.8277777)));
		postBagel.setLocations(locations);
		
		//send post request
		Response response = given().auth().basic(RestHelper.USERNAME, RestHelper.PASSWORD)
		.and().accept(ContentType.JSON)
		.and().contentType(ContentType.JSON)
		.and().body(postBagel)
		.when().post(RestHelper.getUri());
		//checking status code
		assertEquals(400, response.getStatusCode());
		
	}
}








