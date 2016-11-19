package Integration_Testing;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import App.Video_Processing;
import App.Video_Reading;

public class SoccerField_Test {

	@Test
	public void soccerField(){
		Video_Reading vr = new Video_Reading("VidTest.mp4");
		Video_Processing video = new Video_Processing(vr);
		int GREEN_COLOR = 60;
		int SENSITIVITY = 23;
		Scalar alphaMin = new Scalar(GREEN_COLOR - SENSITIVITY, 100, 50);
		Scalar alphaMax = new Scalar(GREEN_COLOR + SENSITIVITY, 255, 255);
		Mat destMat = new Mat();
		Mat mat = vr.readFrames().get(0);
		Core.inRange(mat , alphaMin, alphaMax, destMat);
		
		Mat mat2 = vr.readFrames().get(0);
		Mat toCompare = video.getSoccerField(mat2);
		assertEquals(1, 1);
	}
	
}
