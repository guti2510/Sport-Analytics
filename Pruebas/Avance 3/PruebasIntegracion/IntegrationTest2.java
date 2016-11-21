package PruebasIntegracion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;

import SegmentacionTemporal.ControladorSegmentador;

public class IntegrationTest2 {

	
	private static String pNombreVideo;
	private static String pNombreGround;
	ControladorSegmentador controlador = new ControladorSegmentador();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		pNombreVideo = "C:\\Users\\juanj\\workspace\\SegmentacionTemporal\\src\\Video.MP4";
		pNombreGround = "C:\\Users\\juanj\\workspace\\SegmentacionTemporal\\GroundtruthPrueba.json";
	}

	@Test
	public void test() {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		String resultado = controlador.comprarGround(pNombreVideo, pNombreGround);
		
		String resultadoesperado = "{\"data\":[{\"CantCortes\":302,\"CantFalsoNegativo\":11,\"CantFalsoPositivo\":151}]}";
		
		
		assertEquals( resultadoesperado , resultado);
		
		
	}

}
