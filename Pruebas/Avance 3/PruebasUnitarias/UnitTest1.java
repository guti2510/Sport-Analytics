package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import SegmentacionTemporal.OpenCVEditor;
import SegmentacionTemporal.VideoEditor;

public class UnitTest1 {

	static Mat matriz;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		
		VideoEditor openCvEdit = new OpenCVEditor();
		
		ArrayList<Mat> rawFrame = new ArrayList<>();
		
		rawFrame = openCvEdit.obtenerFrames("src/Video.MP4");
		ArrayList<Mat> listaHist = new ArrayList<>();
		
		/*	Transformacion del RGB a HSV	*/
	    Mat hsv = new Mat();
	    hsv = openCvEdit.transformarHSV(rawFrame.get(0));
	      	        
	    /*	Separa la capa de H de las demas	*/
	    Mat capaH = new Mat();
	    capaH = openCvEdit.extraerCapaH(hsv);
	    
	    matriz = capaH;
	}

	@Test
	public void test() {
		
		VideoEditor openCvEdit = new OpenCVEditor();
		
		Mat resultado;
		//Probamos la funcion de calcularHistograma
		resultado = openCvEdit.calcularHistograma(matriz);
		
		//Realizamos un for para crear un valor que se va a utilizar en el assertEquals
		int resultadofinal = 0;
		for (int i = 0; i < resultado.height(); i++)
	        for (int j = 0; j < resultado.width(); j++) {
	        	resultadofinal += resultado.get(i, j)[0];
	    }
		
		
		int resultadoesperado = 153596;
		
		/*Verificamos que los pixeles esten correctos*/
	    assertEquals( resultadoesperado , resultadofinal);
		
	}

}
