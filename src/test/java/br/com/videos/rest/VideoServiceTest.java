package br.com.videos.rest;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.videos.model.Video;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
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
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(video).when()
				.post(path).then().statusCode(204).contentType("application/json").extract()
				.response();
		
		assertEquals(204, response.getStatusCode());
		
	}
	
	
	@Test
	public void testEStatistics() {
		
		
		String path = CONTEXT_PATH + "/statistics";
		Response response = given().contentType(ContentType.JSON).get(path);
		assertEquals(200, response.getStatusCode());
				
	}
	
	@Test
	public void testEStatisticsConteudo() {
		
		String path = CONTEXT_PATH + "/statistics";
		Response response = given().contentType(ContentType.JSON).get(path);
		Double sum = Double.parseDouble(response.jsonPath().getString("sum"));
		assertEquals(200.3, sum, 0D);;
				
	}

	@Test
	public void testRestDelete() {
		String path = CONTEXT_PATH + "/videos";
		Response response = given().contentType(ContentType.JSON).delete(path);
		assertEquals(204, response.getStatusCode());
	}

	@Test
	public void testEstatisticsSemVideos() {
		
		String path = CONTEXT_PATH + "/statistics";
		Response response = given().contentType(ContentType.JSON).get(path);
		assertEquals(200, response.getStatusCode());
				
	}

}
