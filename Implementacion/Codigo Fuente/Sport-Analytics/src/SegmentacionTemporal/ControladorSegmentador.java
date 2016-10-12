package SegmentacionTemporal;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class ControladorSegmentador {
	private AlgoritmoSegmentacion segmentacion = new SegmentadorTemporal();
	
	public String generarArchivoCortes(String pNombreVideo){
		String archivo;
		this.segmentacion.detectarCortes(pNombreVideo);
		archivo = this.segmentacion.generarArchivo();
		if(archivo == null)
			return "";
		return archivo;
	}
	//"Groundtruth.json"
	public String comprarGround(String pNombreVideo, String pNombreGround){
		
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
