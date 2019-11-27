package br.com.videos.model;

public class Video {
	
	private double duration;
	private long timestamp;
	
	public Video() {}
	
	public Video(double duration, long timestamp) {
		this.duration = duration;
		this.timestamp = timestamp;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}
