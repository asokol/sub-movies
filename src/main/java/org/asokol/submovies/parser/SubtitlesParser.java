package org.asokol.submovies.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.asokol.submovies.entities.MovieSubtitles;
import org.asokol.submovies.entities.MovieTime;
import org.asokol.submovies.entities.Phrase;

/**
 * This class provides movie subtitles parsing.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class SubtitlesParser {

	/**
	 * Represents constant subtitles time pattern. String that matches pattern:
	 * "02:08:26,281 --> 02:08:28,032".
	 */
	private final static Pattern SUBTITLES_TIME_PATTERN = Pattern
			.compile("(\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d) --> (\\d\\d:\\d\\d:\\d\\d,\\d\\d\\d)");

	public SubtitlesParser() {
	}

	/**
	 * Parses subtitles from given file name.
	 * 
	 * @param fileName
	 *            the file name to get subtitles from
	 * @return parsed movie subtitles from given file
	 * @throws SubtitlesParserException
	 *             if any error occurs while parsing subtitles
	 */
	public MovieSubtitles parseSubtitlies(String fileName)
			throws SubtitlesParserException {
		MovieSubtitles result = new MovieSubtitles();
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(fileName);
		if (inputStream == null) {
			try {
				inputStream = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				throw new SubtitlesParserException("File " + fileName
						+ " is not found.", e);
			}
		}
		// parse subtitles from file
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String line = reader.readLine();
			List<Phrase> phrases = new ArrayList<Phrase>();
			while (line != null) {
				if (isPhraseTime(line)) {
					// get phrase time
					Phrase phrase = parsePhraseTime(line);
					StringBuilder text = new StringBuilder();
					// get phrase text
					while (isPhraseText(line = reader.readLine())) {
						text.append(line).append(" ");
					}
					phrase.setText(text.toString());
					phrases.add(phrase);
				} else {
					line = reader.readLine();
				}
			}
			result.setPhrases(phrases);
			result.setLanguage("en");
		} catch (IOException e) {
			throw new SubtitlesParserException(
					"IO error occurred while parsing " + fileName + ".", e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// ignore
			}
		}

		return result;
	}

	private static boolean isPhraseText(String line) {
		return line != null && line.trim().length() > 0;
	}

	private static boolean isPhraseTime(String line) {
		return SUBTITLES_TIME_PATTERN.matcher(line).matches();
	}

	private static Phrase parsePhraseTime(String phraseTimeText) {
		Matcher matcher = SUBTITLES_TIME_PATTERN.matcher(phraseTimeText);
		if (matcher.matches()) {
			String startTimeText = matcher.group(1);
			String endTimeText = matcher.group(2);
			Phrase phrase = new Phrase();
			phrase.setStartTime(parseMovieTime(startTimeText));
			phrase.setEndTime(parseMovieTime(endTimeText));
			return phrase;
		}
		return null;
	}

	private static MovieTime parseMovieTime(String movieTimeText) {
		String[] times = movieTimeText.split(":");
		String hours = times[0];
		String minutes = times[1];
		String seconds = times[2].split(",")[0];
		String milliseconds = times[2].split(",")[1];
		MovieTime movieTime = new MovieTime();
		movieTime.setHours(Integer.parseInt(hours));
		movieTime.setMinutes(Integer.parseInt(minutes));
		movieTime.setSeconds(Integer.parseInt(seconds));
		movieTime.setMilliseconds(Integer.parseInt(milliseconds));
		return movieTime;
	}
}
