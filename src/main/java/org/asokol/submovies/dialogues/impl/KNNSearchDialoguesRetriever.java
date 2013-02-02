/**
 * 
 */
package org.asokol.submovies.dialogues.impl;

import org.asokol.submovies.dialogues.DialoguesRetriever;
import org.asokol.submovies.dialogues.DialoguesRetrieverException;
import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;

/**
 * This class provides retrieving of movie dialogues from subtitles using kNN search algorithm.
 * @author asokol
 * @version 1.0
 *
 */
public class KNNSearchDialoguesRetriever implements DialoguesRetriever {

	
	public KNNSearchDialoguesRetriever() {
	}
	
	public MovieDialogues retrieveDialogues(MovieSubtitles subtitles)
			throws DialoguesRetrieverException {
		throw new UnsupportedOperationException("not yet implemented!");
	}

}
