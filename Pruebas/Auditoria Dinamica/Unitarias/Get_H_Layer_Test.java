package Unit_Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.opencv.core.Mat;

import App.Video_Processing;
import App.Video_Reading;

public class Get_H_Layer_Test {
	
	@Test 
	public void getHlayerTestEmpty(){
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		ArrayList<Mat> frames = vr.readFrames();
		ArrayList<Mat> hsvArrayList = video.convertToHSV(frames);
		ArrayList<Mat> hArrayList = video.getHlayer(hsvArrayList);
		assertFalse(hsvArrayList.isEmpty());
	}
	
	@Test
	public void getHlayerTestSize() {
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		ArrayList<Mat> frames = vr.readFrames();
		ArrayList<Mat> hsvArrayList = video.convertToHSV(frames);
		ArrayList<Mat> hArrayList = video.getHlayer(hsvArrayList);
		int amountOfFrames = hArrayList.size();
		assertEquals(60, amountOfFrames);
	}

}
