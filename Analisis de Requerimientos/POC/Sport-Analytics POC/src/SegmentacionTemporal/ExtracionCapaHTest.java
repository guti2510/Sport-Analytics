package SegmentacionTemporal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opencv.core.Core;
import org.opencv.core.Mat;

public class ExtracionCapaHTest {


	@Test
	public void test() {
		
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		/*Esta prueba hace la extraccion de la capa H del HSV*/
		AperturaVideo aperturavideo = new AperturaVideo();
		
		Mat Frame = new Mat();
		Frame = aperturavideo.SacarFrame("C:\\Users\\Alex\\Documents\\GitHub\\Sport-Analytics\\Video.MP4");
		
		Mat HSV = new Mat();
		HSV = aperturavideo.TransformacionHSV(Frame);
		
		/*Esta es la funcion que se esta probando*/
		Mat capaH = new Mat();
	    capaH = aperturavideo.ExtracionCapaH(HSV);
		   
	    
	    /*Se extrae la capa H del Mat para verificar que este correcto*/
	    double h = 0;

	    for (int i = 0; i < capaH.height(); i++)
	        for (int j = 0; j < capaH.width(); j++) {
	            h += capaH.get(i, j)[0];
	    }

	    /* Lo pasamos a un int assertEquals*/
	    int totalCapaH = (int)h;

	    /*Verificamos que los pixeles esten correctos*/
	    assertEquals( 7337178 , totalCapaH);
	    
	}

}
