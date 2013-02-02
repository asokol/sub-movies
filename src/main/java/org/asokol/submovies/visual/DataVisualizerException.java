/**
 * 
 */
package org.asokol.submovies.visual;

/**
 * This class represents exception occurred while visualizing data.
 * @author asokol
 * @version 1.0
 *
 */
public class DataVisualizerException extends Exception {

	private static final long serialVersionUID = 5247818709042622130L;

	public DataVisualizerException(String message) {
		super(message);
	}
	
	public DataVisualizerException(String message, Throwable cause) {
		super(message, cause);
	}
}
