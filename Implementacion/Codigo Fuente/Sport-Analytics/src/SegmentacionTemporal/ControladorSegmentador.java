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

import Excepciones.ErrorEditor;
import Excepciones.ErrorJson;

public class ControladorSegmentador {
	private AlgoritmoSegmentacion segmentacion = new SegmentadorTemporal();
	
	/**
	 * Genera el archivo con los cortes detectados en el analisis del video  
	 *
	 * @param  		pNombreVideo - Un string con el nombre del video a analizar
	 * @return      archivo - Un string con el nombre del archivo creado
	 * @throws ErrorJson 
	 * @throws ErrorEditor 
	*/
	public String generarArchivoCortes(String pNombreVideo) throws ErrorJson, ErrorEditor{
		String archivo;
		try {
			this.segmentacion.detectarCortes(pNombreVideo);
			archivo = this.segmentacion.generarArchivo();
			if(archivo == null)
				return "";
			return archivo;
		} catch (ErrorEditor e) {
			throw e;
		}
		
	}

	/**
	 * Realiza la comparacion de falsos positivos y negativos entre el video analizado 
	 * y el groundtruth  
	 *
	 * @param  		pNombreVideo - Un string con el nombre del video a analizar
	 * @param  		pNombreGround - Un string con el nombre del archivo de Groundtruth
	 * @return      reporte - Un reporte de la comparacion de estos dos
	 * @throws Exception 
	*/
	public String comprarGround(String pNombreVideo, String pNombreGround) throws Exception{
		//"Groundtruth.json"
		LecturaArchivo archivo = new LecturaArchivo();
		ArrayList<InfoFrame> listaArchivo;
		try {
			listaArchivo = archivo.leerArchivo(pNombreGround);
		} catch (IOException | ParseException | ErrorJson e) {
			throw new Exception(e.getMessage());
		}
		this.segmentacion.detectarCortes(pNombreVideo);
		InfoReporte reporte = this.segmentacion.validarResultado(listaArchivo);
		return this.segmentacion.generarReporte(reporte);
	}
}
