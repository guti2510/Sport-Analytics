package SegmentacionTemporal;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.opencv.core.Core;

public class Main {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		ControladorSegmentador controlador = new ControladorSegmentador();
		String archvivo = controlador.generarArchivoCortes("Video.MP4");
		System.out.println(archvivo);
		
		String reporte = controlador.comprarGround("Video.MP4", "Groundtruth.json");
		System.out.println(reporte);

	}

}
