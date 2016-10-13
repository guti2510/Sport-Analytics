package SegmentacionTemporal;

/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 */

import java.util.ArrayList;

import org.opencv.core.Mat;

public interface AlgoritmoSegmentacion {

	public ArrayList<Double> calcularSimilitudHist(ArrayList<Mat> listaHist);
	public void clasificarFrames(ArrayList<Double> pListaBhata);
	public void detectarCortes(String nombrevideo);
	public InfoReporte validarResultado(ArrayList<InfoFrame> pLista);
	public String generarArchivo();
	public String generarReporte(InfoReporte pReporte);
	public double calcularMedia(ArrayList<Double> pListaBhata);
	public double calcularDesviacion(ArrayList<Double> pListaBhata, double pMedia);
}
