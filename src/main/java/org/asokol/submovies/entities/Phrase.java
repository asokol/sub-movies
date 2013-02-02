package org.asokol.submovies.entities;

/**
 * This class represents distinct phrase in movies subtitles.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class Phrase {
	private String text;
	private MovieTime startTime;
	private MovieTime endTime;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MovieTime getStartTime() {
		return startTime;
	}

	public void setStartTime(MovieTime startTime) {
		this.startTime = startTime;
	}

	public MovieTime getEndTime() {
		return endTime;
	}

	public void setEndTime(MovieTime endTime) {
		this.endTime = endTime;
	}

	public Phrase() {
	}
	
	public int distance(Phrase other) {
		return startTime.getTime() - other.endTime.getTime();
	}

}
