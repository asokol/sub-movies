package org.asokol.submovies.visual;

import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;

/**
 * This interface provides contract for data visualization.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public interface DataVisualizer {
	public void drawSubtitles(MovieSubtitles subtitles)
			throws DataVisualizerException;

	public void drawDialogues(MovieDialogues dialogues)
			throws DataVisualizerException;
}
