/**
 * 
 */
package org.asokol.submovies.dialogues.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.asokol.submovies.dialogues.DialoguesRetriever;
import org.asokol.submovies.dialogues.DialoguesRetrieverException;
import org.asokol.submovies.entities.Dialogue;
import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;
import org.asokol.submovies.entities.Phrase;

/**
 * <p>
 * This class represents naive implementation of dialogues retriever.
 * </p>
 * <p>
 * Threshold value is used to distinguish dialogues from each other.
 * </p>
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class NaiveDeltaDialoguesRetriever implements DialoguesRetriever {

	/**
	 * Represents threshold for maximum pause in dialogue.
	 */
	private static final int DIALOGUE_PAUSE_THRESHOLD = 5000;
	
	/**
	 * <p>
	 * Retrieves movie dialogues from given movie subtitles using naive
	 * approach.
	 * </p>
	 * <p>
	 * It finds threshold value that minimize dialogues count. Main idea: two
	 * adjacent phrases that have distance greater than threshold are considered
	 * to be in different dialogues.
	 * </p>
	 * 
	 * 
	 * @param subtitles
	 *            the movie subtitles
	 * @return movie dialogues retrieved from given movie subtitles
	 * @throws DialoguesRetrieverException
	 *             if any error occurs while retrieving movie dialogues
	 */
	public MovieDialogues retrieveDialogues(MovieSubtitles subtitles)
			throws DialoguesRetrieverException {
		MovieDialogues movieDialogues = findDialogues(subtitles.getPhrases(), DIALOGUE_PAUSE_THRESHOLD);
		return movieDialogues;
	}
	
	private static MovieDialogues findDialogues(List<Phrase> phrases, int maximumDialoguePause) {
		MovieDialogues result = new MovieDialogues();
		List<Dialogue> dialogues = new ArrayList<Dialogue>(); 
		Iterator<Phrase> iter = phrases.iterator();
		Phrase previous = iter.next();
		Phrase next = iter.next();
		Dialogue dialogue = new Dialogue();
		dialogue.addPhrase(previous);
		while(iter.hasNext()) {
			if (next.distance(previous) > maximumDialoguePause) {
				dialogues.add(dialogue);
				dialogue = new Dialogue();
			} else {
				dialogue.addPhrase(next);
			}
			previous = next;
			next = iter.next();
		}
		result.setDialogues(dialogues);
		return result;
	}

}
