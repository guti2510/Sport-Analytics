package PruebasIntegracion;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;

import SegmentacionTemporal.AlgoritmoSegmentacion;
import SegmentacionTemporal.InfoFrame;
import SegmentacionTemporal.InfoReporte;
import SegmentacionTemporal.LecturaArchivo;
import SegmentacionTemporal.SegmentadorTemporal;

public class IntegrationTest4 {

	private static String pNombreGround;
	private static String pNombreVideo;
	static ArrayList<InfoFrame> listaArchivo;
	private static AlgoritmoSegmentacion segmentacion = new SegmentadorTemporal();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		pNombreGround = "C:\\Users\\juanj\\workspace\\SegmentacionTemporal\\GroundtruthPrueba.json";
		pNombreVideo = "C:\\Users\\juanj\\workspace\\SegmentacionTemporal\\src\\Video.MP4";
		
	}

	@Test
	public void test() {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		LecturaArchivo archivo = new LecturaArchivo();
		try {
			listaArchivo = archivo.leerArchivo(pNombreGround);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			listaArchivo = new ArrayList<>();
		}
		segmentacion.detectarCortes(pNombreVideo);
		InfoReporte resultado = segmentacion.validarResultado(listaArchivo);
	
		
		int resultadoesperado = 11;
		
		assertEquals( resultadoesperado , resultado.getCantFalsosNegativos());
		
	}

}
