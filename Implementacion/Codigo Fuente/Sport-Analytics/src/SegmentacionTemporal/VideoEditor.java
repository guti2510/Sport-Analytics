package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */

import java.util.ArrayList;

import org.opencv.core.Mat;

public interface VideoEditor {

	public Mat transformarHSV (Mat frame);
	public Mat extraerCapaH (Mat HSV);
	public ArrayList<Mat> obtenerFrames(String nombrevideo);
	public Mat calcularHistograma (Mat matriz);
	
}
