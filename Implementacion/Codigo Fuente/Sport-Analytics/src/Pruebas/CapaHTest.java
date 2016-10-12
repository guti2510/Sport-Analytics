package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import SegmentacionTemporal.OpenCVEditor;
import SegmentacionTemporal.VideoEditor;

public class CapaHTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {


		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		
		VideoEditor openCvEdit = new OpenCVEditor();
		
		ArrayList<Mat> rawFrame = new ArrayList<>();
		
		rawFrame = openCvEdit.obtenerFrames("Video.MP4");
		ArrayList<Mat> listaHist = new ArrayList<>();
		
		/*	Transformacion del RGB a HSV	*/
	    Mat hsv = new Mat();
	    hsv = openCvEdit.transformarHSV(rawFrame.get(0));
	      	        
	    /*	Separa la capa de H de las demas	*/
	    Mat capaH = new Mat();
	    capaH = openCvEdit.extraerCapaH(hsv);
	    
	    /*Se extrae la capa H del Mat para verificar que este correcto*/
	    double h = 0;

	    for (int i = 0; i < capaH.height(); i++)
	        for (int j = 0; j < capaH.width(); j++) {
	            h += capaH.get(i, j)[0];
	    }

	    /* Lo pasamos a un int assertEquals*/
	    int resultado = (int)h;
	    
	    int resultadoesperado = 10620432;
	    
	    /*Verificamos que los pixeles esten correctos*/
	    assertEquals( resultadoesperado , resultado);
	    
		
	}

}
