package br.com.videos.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.videos.model.Estatistica;
import br.com.videos.model.Video;

public class EstatisticaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculaEstatistica() {
		
		Estatistica estatistica = new Estatistica();
		List<Video> videos = new ArrayList<>();
		Video video1 = new Video();
		video1.setDuration(200.3);
		video1.setTimestamp(1571577420102L);
		
		Video video2 = new Video();
		video2.setDuration(300.2);
		video2.setTimestamp(1571577420100L);
		
		videos.add(video1);
		videos.add(video2);
		
		estatistica.calculaEstatistica(videos);
		
		assertEquals(2, estatistica.getCount());
		assertEquals(500.5, estatistica.getSum(), 0D);
		assertEquals(250.25, estatistica.getAvg(), 0D);
		assertEquals(300.2, estatistica.getMax(), 0D);
		assertEquals(200.3, estatistica.getMin(), 0D);
	}
	
	@Test
	public void testCalculaEstatisticaComListaVazia() {
		
		Estatistica estatistica = new Estatistica();
		List<Video> videos = new ArrayList<>();
		
		estatistica.calculaEstatistica(videos);
		
		assertEquals(0, estatistica.getCount());
		assertEquals(0.0, estatistica.getSum(), 0D);
		assertEquals(0.0, estatistica.getAvg(), 0D);
		assertEquals(Double.MIN_VALUE, estatistica.getMax(), 0D);
		assertEquals(Double.MAX_VALUE, estatistica.getMin(), 0D);
	}

}
