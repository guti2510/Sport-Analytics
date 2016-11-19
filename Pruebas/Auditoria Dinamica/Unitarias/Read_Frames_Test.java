package Unit_Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.opencv.core.Mat;

import App.Video_Processing;
import App.Video_Reading;

public class Read_Frames_Test {

	@Test
	public void readFramesEmpty(){
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		ArrayList<Mat> frames = vr.readFrames();
		assertFalse(frames.isEmpty());
	}
	
	@Test
	public void readFramesTestSize() {
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		ArrayList<Mat> frames = vr.readFrames();
		int amountOfFrames = frames.size();
		assertEquals(60, amountOfFrames);
	}

}
