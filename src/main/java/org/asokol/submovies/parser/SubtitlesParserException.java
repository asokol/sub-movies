package org.asokol.submovies.parser;

/**
 * This class represents exception occurred during parsing subtitles.
 * @author asokol
 * @version 1.0
 *
 */
public class SubtitlesParserException extends Exception {
	
	private static final long serialVersionUID = -5039461697656432294L;

	public SubtitlesParserException(String message) {
		super(message);
	}
	
	public SubtitlesParserException(String message, Throwable cause) {
		super(message, cause);
	}

}
