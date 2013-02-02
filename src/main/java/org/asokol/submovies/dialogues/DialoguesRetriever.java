package org.asokol.submovies.dialogues;

import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;

/**
 * 
 * This interface provides contract for retrieving dialogues from movie
 * subtitles.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public interface DialoguesRetriever {
	/**
	 * Retrieves movie dialogues from given movie subtitles.
	 * 
	 * @param subtitles
	 *            the movie subtitles
	 * @return movie dialogues retrieved from given movie subtitles
	 * @throws DialoguesRetrieverException
	 *             if any error occurs while retrieving movie dialogues
	 */
	public MovieDialogues retrieveDialogues(MovieSubtitles subtitles)
			throws DialoguesRetrieverException;
}
