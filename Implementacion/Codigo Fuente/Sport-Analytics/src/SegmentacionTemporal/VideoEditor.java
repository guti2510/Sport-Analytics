package SegmentacionTemporal;

import java.util.ArrayList;

import org.opencv.core.Mat;

public interface VideoEditor {

	public Mat transformarHSV (Mat frame);
	public Mat extraerCapaH (Mat HSV);
	public ArrayList<Mat> obtenerFrames(String nombrevideo);
	public Mat calcularHistograma (Mat matriz);
	
}
