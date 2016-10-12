package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import SegmentacionTemporal.OpenCVEditor;
import SegmentacionTemporal.VideoEditor;

public class TransformarHSVTest {

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
		
		/*	PROBAMOS LA: Transformacion del RGB a HSV	*/
	    Mat hsv = new Mat();
	    hsv = openCvEdit.transformarHSV(rawFrame.get(0));
	    
	    double h = 0;
	    double s = 0;
	    double v = 0;
	    		
	    for (int i = 0; i < hsv.height(); i++)
	        for (int j = 0; j < hsv.width(); j++) {
	            h += hsv.get(i, j)[0];
	            s += hsv.get(i, j)[1];
	            v += hsv.get(i, j)[2];
	    }

	    /* Lo sumamos para poder realizar el assertEquals*/
	    int resultado = (int)h  + (int)s  +(int)v;
	    
	    int resultadoesperado = 37731555;
	    
	    /*Verificamos que los pixeles esten correctos*/
	    assertEquals( resultadoesperado , resultado);
	    
	}

}
