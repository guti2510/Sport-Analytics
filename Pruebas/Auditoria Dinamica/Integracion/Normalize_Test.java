package Integration_Testing;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import App.Video_Processing;
import App.Video_Reading;

public class Normalize_Test {
	
	@Test
	public void normalize(){
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		ArrayList<Mat> frames = vr.readFrames();
		ArrayList<Mat> HSV = video.convertToHSV(frames);
		ArrayList<Mat> H = video.getHlayer(HSV);
		Mat clone = H.get(0);
		Core.normalize(clone, clone, 0, 255, Core.NORM_MINMAX);

		Mat normalizeMat = video.normalize(H.get(0), 0, 255);
		
		assertEquals(clone, normalizeMat);
	}

}
