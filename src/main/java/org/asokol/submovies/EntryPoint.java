package org.asokol.submovies;

import java.util.Scanner;

import org.asokol.submovies.dialogues.DialoguesRetriever;
import org.asokol.submovies.dialogues.impl.NaiveDeltaDialoguesRetriever;
import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;
import org.asokol.submovies.parser.SubtitlesParser;
import org.asokol.submovies.visual.DataVisualizer;
import org.asokol.submovies.visual.impl.JChartDrawer;

/**
 * This class provides data visualization for subtitles.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class EntryPoint {
	private static final String DIRECTORY_OPTION = "-dir=";
	private static final String FILE_OPTION = "-file=";

	// -file=filename | -dir=dirname
	public static void main(String[] args) throws Exception {
		DataVisualizer visualizer = new JChartDrawer();
		SubtitlesParser subtitlesParser = new SubtitlesParser();
		DialoguesRetriever dialoguesRetriever = new NaiveDeltaDialoguesRetriever();
		if (args.length > 0) {
			String option = args[0];
			if (option.startsWith(FILE_OPTION)) {
				String fileName = option.substring(FILE_OPTION.length());
				// parse subtitles
				MovieSubtitles subtitles = subtitlesParser.parseSubtitlies(fileName);
				// draw subtitles
				visualizer.drawSubtitles(subtitles);
				// retrieve dialogues
				MovieDialogues dialogues = dialoguesRetriever.retrieveDialogues(subtitles);
				// draw dialogues
				visualizer.drawDialogues(dialogues);
			} else if (option.startsWith(DIRECTORY_OPTION)) {
				throw new UnsupportedOperationException("not yet implemented!");
			}
		} else {
			// show options
			printHelp();

		}
	}

	private static void printHelp() {
		System.out.println("Usage: ");
		System.out
				.println("       -file=path_to_some_file        - parses specific file");
		System.out
		.println("                -OR-                   ");
		System.out
				.println("       -dir=directory_of_some_files   - parses all files in specific directory");
	}
}
