package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class ControladorSegmentador {
	private AlgoritmoSegmentacion segmentacion = new SegmentadorTemporal();
	
	/**
	 * Genera el archivo con los cortes detectados en el analisis del video  
	 *
	 * @param  		pNombreVideo - Un string con el nombre del video a analizar
	 * @return      archivo - Un string con el nombre del archivo creado
	*/
	public String generarArchivoCortes(String pNombreVideo){
		String archivo;
		this.segmentacion.detectarCortes(pNombreVideo);
		archivo = this.segmentacion.generarArchivo();
		if(archivo == null)
			return "";
		return archivo;
	}

	/**
	 * Realiza la comparacion de falsos positivos y negativos entre el video analizado 
	 * y el groundtruth  
	 *
	 * @param  		pNombreVideo - Un string con el nombre del video a analizar
	 * @param  		pNombreGround - Un string con el nombre del archivo de Groundtruth
	 * @return      reporte - Un reporte de la comparacion de estos dos
	*/
	public String comprarGround(String pNombreVideo, String pNombreGround){
		//"Groundtruth.json"
		LecturaArchivo archivo = new LecturaArchivo();
		ArrayList<InfoFrame> listaArchivo;
		try {
			listaArchivo = archivo.leerArchivo(pNombreGround);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			listaArchivo = new ArrayList<>();
		}
		this.segmentacion.detectarCortes(pNombreVideo);
		InfoReporte reporte = this.segmentacion.validarResultado(listaArchivo);
		return this.segmentacion.generarReporte(reporte);
	}
}
