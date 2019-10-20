package br.com.sambatech.rest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.sambatech.model.Video;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VideoServiceTest {

	private final String CONTEXT_PATH = "/rest-videos/rest";

	@Before
	public void setUp() throws Exception {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		
	}

	@Test
	public void testAddWithCodeStatus201() {
		
		String path = CONTEXT_PATH + "/videos";
		Video video = new Video();
		video.setDuration(200.3);
		long time = System.currentTimeMillis();
		video.setTimestamp(time);
		
		Response response = given().contentType("application/json").accept("application/json")
				.body(video).when()
				.post(path).then().statusCode(201).contentType("application/json").extract()
				.response();
		
		int status_cod = response.getStatusCode();
		assertEquals(201, status_cod);
		
	}
	
	@Test
	public void testAddWithCodeStatus204() {
		
		String path = CONTEXT_PATH + "/videos";
		Video video = new Video();
		video.setDuration(200.3);
		long time = System.currentTimeMillis();
		video.setTimestamp(time - 6001);
		
		Response response = given().contentType("application/json").accept("application/json").body(video).when()
				.post(path).then().statusCode(204).contentType("application/json").extract()
				.response();
		
		int status_cod = response.getStatusCode();
		assertEquals(204, status_cod);
		
	}


	@Test
	public void testDelete() {
		
	}

	@Test
	public void testStatistics() {
		
		
		
	}

}
