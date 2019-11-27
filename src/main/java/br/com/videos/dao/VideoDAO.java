package br.com.videos.dao;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.videos.model.Video;

public class VideoDAO {
	
	private static HashMap<Long, Video> banco = new HashMap<Long, Video>();
	private static AtomicLong contador = new AtomicLong(1);
	
	static {
		Video video1 = new Video(300.2, System.currentTimeMillis());
		Video video2 = new Video(200.3, System.currentTimeMillis() - 600);
		
		banco.put(1L, video1);
		banco.put(2L, video2);
		
	}
	
	public void adicionaVideo(Video video) {
		Long id = contador.incrementAndGet();
		banco.put(id, video);
		
	}

	public List<Video> buscaVideos() {
		
		return (List<Video>) banco.values();
	}

}
