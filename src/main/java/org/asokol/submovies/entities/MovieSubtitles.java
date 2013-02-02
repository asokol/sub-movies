package org.asokol.submovies.entities;

import java.util.List;

/**
 * This class represents movie subtitles entity.
 * @author asokol
 *
 */
public class MovieSubtitles {
	private String language;
	/**
	 * Represents phrases in movies.
	 * Sorted in ascending order according to time in movie. 
	 */
	private List<Phrase> phrases;
	
	public MovieSubtitles() {
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}
	
	
	
}
