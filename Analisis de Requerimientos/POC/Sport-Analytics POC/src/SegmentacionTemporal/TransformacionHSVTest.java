package SegmentacionTemporal;

import static org.junit.Assert.*;


import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class TransformacionHSVTest {

	@Test
	public void test() {
		
		/*Esta prueba hace la transformacion de un frame de RGB a HSV*/
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		AperturaVideo aperturavideo = new AperturaVideo();
		
		Mat Frame = new Mat();
		Frame = aperturavideo.SacarFrame("C:\\Users\\Alex\\Documents\\GitHub\\Sport-Analytics\\Video.MP4");
		
		/*Esta es la funcion que se va a probar*/
		Mat HSV = new Mat();
		HSV = aperturavideo.TransformacionHSV(Frame);

		
		/*Se saca el H S V del Mat para verificar que este correcto*/
		
	    double h = 0;
	    double s = 0;
	    double v = 0;
	    		
	    for (int i = 0; i < HSV.height(); i++)
	        for (int j = 0; j < HSV.width(); j++) {
	            h += HSV.get(i, j)[0];
	            s += HSV.get(i, j)[1];
	            v += HSV.get(i, j)[2];
	    }

	    /* Lo sumamos para poder realizar el assertEquals*/
	    int totalFramenHSV = (int)h  + (int)s  +(int)v;

	    /*Verificamos que los pixeles esten correctos*/
	    assertEquals( 37731555 , totalFramenHSV);
	    
	}

}
