/**
 * 
 */
package org.asokol.submovies.visual.impl;

import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.ZoomableChart;
import info.monitorenter.gui.chart.traces.Trace2DSimple;
import info.monitorenter.gui.chart.traces.painters.TracePainterDisc;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;

import org.asokol.submovies.entities.Dialogue;
import org.asokol.submovies.entities.MovieDialogues;
import org.asokol.submovies.entities.MovieSubtitles;
import org.asokol.submovies.entities.Phrase;
import org.asokol.submovies.visual.DataVisualizer;
import org.asokol.submovies.visual.DataVisualizerException;

/**
 * This class provides data visualization using GNU Plot.
 * 
 * @author asokol
 * @version 1.0
 * 
 */
public class JChartDrawer implements DataVisualizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.asokol.submovies.visual.DataVisualizer#drawSubtitles(org.asokol.submovies
	 * .entities.MovieSubtitles)
	 */
	public void drawSubtitles(MovieSubtitles subtitles)
			throws DataVisualizerException {

		// Create a chart:
		Chart2D chart = new ZoomableChart();
		addTrace(chart, subtitles.getPhrases(), Color.BLACK);
		createFrame(chart, "Subtitles chart");
	}

	private static void addTrace(Chart2D chart, List<Phrase> phrases,
			Color color) {
		// Create an ITrace:
		ITrace2D trace = new Trace2DSimple();
		trace.setTracePainter(new TracePainterDisc(2));
		trace.setColor(color);
		// Add the trace to the chart. This has to be done before adding points
		// (deadlock prevention):
		chart.addTrace(trace);
		// Add all points, as it is static:
		for (Phrase phrase : phrases) {
			trace.addPoint(phrase.getStartTime().getTime() / 1000, phrase
					.getEndTime().getTime() / 1000);
		}
	}

	private static void createFrame(Chart2D chart, String title) {
		// Make it visible:
		// Create a frame.
		JFrame frame = new JFrame(title);
		// add the chart to the frame:
		frame.getContentPane().add(chart);
		frame.setSize(400, 300);
		// Enable the termination button [cross on the upper right edge]:
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.asokol.submovies.visual.DataVisualizer#drawDialogues(org.asokol.submovies
	 * .entities.MovieDialogues)
	 */
	public void drawDialogues(MovieDialogues dialogues)
			throws DataVisualizerException {
		// Create a chart:
		Chart2D chart = new ZoomableChart();
		int dialoguesCount = dialogues.getDialogues().size();
		int step = 0xFFFFFF / (dialoguesCount + 1);
		int rgb = step;
		for (Dialogue dialogue : dialogues.getDialogues()) {
			Color color = new Color(rgb);
			addTrace(chart, dialogue.getPhrases(), color);
			rgb += step;
		}
		createFrame(chart, "Dialogues chart. Dialogues count " + dialoguesCount);
	}

}
