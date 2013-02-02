/**
 * 
 */
package org.asokol.submovies.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains test cases for MovieTime.
 * @author asokol
 * @version 1.0
 *
 */
public class MovieTimeTest {

	@Test
	public void testGetTime() {
		MovieTime time = new MovieTime();
		int hours = 2;
		int minutes = 30;
		int seconds = 10;
		int milliseconds = 345;
		time.setHours(hours);
		time.setMinutes(minutes);
		time.setSeconds(seconds);
		time.setMilliseconds(milliseconds);
		int expectedTime = ((hours*60 + minutes)*60 + seconds)*1000 + milliseconds; 
		assertEquals(expectedTime, time.getTime());
	}
}
