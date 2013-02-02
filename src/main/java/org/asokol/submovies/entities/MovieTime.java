package org.asokol.submovies.entities;

/**
 * This class represents time as it appears in movie subtitiles.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class MovieTime {
	private int milliseconds;
	private int seconds;
	private int minutes;
	private int hours;

	public MovieTime() {
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * Retrieves time value in milliseconds.
	 * 
	 * @return time value in milliseconds
	 */
	public int getTime() {
		return ((hours * 60 + minutes) * 60 + seconds) * 1000 + milliseconds;
	}
}
