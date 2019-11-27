package br.com.videos.model;

import java.util.Iterator;
import java.util.List;

public class Estatistica {

	private double sum;
	private double avg;
	private double max;
	private double min;
	private long count;

	public Estatistica() {
		this.max = Double.MIN_VALUE;
		this.min = Double.MAX_VALUE;
		this.sum = 0;
		this.avg = 0;
		this.count = 0;
	}

	public void calculaEstatistica(List<Video> videos) {
		long time_now = System.currentTimeMillis();
		
		Video video;
		Iterator<Video> video_iter = videos.iterator();

		while (video_iter.hasNext()) {
			video = video_iter.next();
			if (time_now - video.getDuration() > 60) {
				this.count++;
				this.sum += video.getDuration();
					
				if (video.getDuration() > max)
					max = video.getDuration();
	
				if (video.getDuration() < min)
					min = video.getDuration();
			}
		}
		if (count > 0)
			this.avg = this.sum / this.count;

	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
