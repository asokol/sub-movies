package org.asokol.submovies.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents movie dialogue entity.
 * @author asokol
 * @version 1.0
 *
 */
public class Dialogue {
	private List<Phrase> phrases;

	public Dialogue() {
		phrases = new ArrayList<Phrase>();
	}
	
	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}
	
	public void addPhrase(Phrase phrase) {
		this.phrases.add(phrase);
	}
	
}
