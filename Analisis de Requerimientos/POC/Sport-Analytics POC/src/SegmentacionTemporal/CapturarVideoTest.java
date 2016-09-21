package SegmentacionTemporal;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class CapturarVideoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		
		/*Esta prueba hace la lectura de un frame del video*/
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		AperturaVideo aperturavideo = new AperturaVideo();
		
		/*Esta es la funcion que captura el frame del video*/
		aperturavideo.CapturarVideo("C:\\Users\\Alex\\Documents\\GitHub\\Sport-Analytics\\Video.MP4");
		
		Mat frameSacado = new Mat();
		frameSacado = Highgui.imread("Frame.jpg");
		
		
		/*Se saca el R G B del Mat para verificar que este correcto*/
		double r = 0;
	    double g = 0;
	    double b = 0;
	    		
	    for (int i = 0; i < frameSacado.height(); i++)
	        for (int j = 0; j < frameSacado.width(); j++) {
	            r += frameSacado.get(i, j)[0];
	            g += frameSacado.get(i, j)[1];
	            b += frameSacado.get(i, j)[2];
	    }
	    
	    /* Lo sumamos para poder realizar el assertEquals*/
	    int totalFramen = (int)r  + (int)g  +(int)b;
	    
	    /*Verificamos que los pixeles esten correctos*/
	    assertEquals( 33259432 , totalFramen);
	    
	}

}
