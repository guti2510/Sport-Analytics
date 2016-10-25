package SegmentacionTemporal;

/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 */

import java.util.ArrayList;

import org.opencv.core.Mat;

import Excepciones.ErrorEditor;
import Excepciones.ErrorJson;

public interface AlgoritmoSegmentacion {

	public ArrayList<Double> calcularSimilitudHist(ArrayList<Mat> listaHist);
	public void clasificarFrames(ArrayList<Double> pListaBhata);
	public void detectarCortes(String nombrevideo) throws ErrorEditor;
	public InfoReporte validarResultado(ArrayList<InfoFrame> pLista);
	public String generarArchivo() throws ErrorJson ;
	public String generarReporte(InfoReporte pReporte);
	public double calcularMedia(ArrayList<Double> pListaBhata);
	public double calcularDesviacion(ArrayList<Double> pListaBhata, double pMedia);
}
