package br.com.sambatech.modelo;

import com.sun.jmx.snmp.Timestamp;

public class Video {
	
	private double duration;
	private Timestamp timestamp;
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
