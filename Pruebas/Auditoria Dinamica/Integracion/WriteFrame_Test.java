package Integration_Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runners.JUnit4;
import org.opencv.core.Mat;

import App.Video_Processing;
import App.Video_Reading;

public class WriteFrame_Test {
	@Test
	public void verifyWriter() {
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		ArrayList<Mat> frames = vr.readFrames();
		int writerCounter = video.writeFrameTestCounter(frames);
		assertEquals(writerCounter, frames.size());
	}
}
