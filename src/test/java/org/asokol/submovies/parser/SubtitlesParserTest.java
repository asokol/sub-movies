/**
 * 
 */
package org.asokol.submovies.parser;

import static org.junit.Assert.*;

import org.asokol.submovies.entities.MovieSubtitles;
import org.asokol.submovies.entities.Phrase;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for SubtitlesParser.
 * @author asokol
 * @version 1.0
 *
 */
public class SubtitlesParserTest {

	private SubtitlesParser parser;
	
	@Before
	public void setUp() {
		parser = new SubtitlesParser();
	}
	
	@Test
	public void parseSubtitles() throws Exception {
		String fileName = "subtitles/TheMatrix.srt";
		int expectedPhrasesCount = 1368;
		MovieSubtitles subtitles = parser.parseSubtitlies(fileName);
		assertNotNull(subtitles);
		assertEquals(expectedPhrasesCount, subtitles.getPhrases().size());
		for(Phrase phrase : subtitles.getPhrases()) {
			assertNotNull(phrase.getText());
			assertTrue(phrase.getText().length() > 0);
		}
	}
	
}
