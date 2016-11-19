package Unit_Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.opencv.core.Mat;

import App.Video_Processing;
import App.Video_Reading;

public class Convert_to_HSV_Test {
	

	@Test
	public void convertToHSVtestEmpty(){
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		ArrayList<Mat> frames = vr.readFrames();
		ArrayList<Mat> hsvArrayList = video.convertToHSV(frames);
		assertFalse(hsvArrayList.isEmpty());
	}

	@Test
	public void convertToHSVtestSize() {
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr); 
		ArrayList<Mat> frames = vr.readFrames();
		ArrayList<Mat> hsvArrayList = video.convertToHSV(frames);
		int amountOfFrames = hsvArrayList.size();
		assertEquals(60, amountOfFrames);
	}

}
