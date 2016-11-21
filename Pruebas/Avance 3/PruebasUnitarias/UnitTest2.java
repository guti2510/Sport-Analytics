package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opencv.core.Core;

import SegmentacionTemporal.AlgoritmoSegmentacion;
import SegmentacionTemporal.ControladorSegmentador;
import SegmentacionTemporal.InfoFrame;
import SegmentacionTemporal.SegmentadorTemporal;

public class UnitTest2 {

	static ArrayList<InfoFrame> listainfoframes = new ArrayList<InfoFrame>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		InfoFrame frame1 = new InfoFrame(0, 10, "FarView");
		InfoFrame frame2 = new InfoFrame(11, 20, "Cut");
		InfoFrame frame3 = new InfoFrame(21, 30, "FarView");
		InfoFrame frame4 = new InfoFrame(31, 40, "Cut");
		
		listainfoframes.add(frame1);
		listainfoframes.add(frame2);
		listainfoframes.add(frame3);
		listainfoframes.add(frame4);
		
	}

	@Test
	public void test() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		ArrayList<Double> resultado = new ArrayList<Double>();
		
		AlgoritmoSegmentacion segmentacion = new SegmentadorTemporal();
		
		//Probamos la funcion buscarCortes.
		resultado = segmentacion.buscarCortes(listainfoframes);
		
		double resultadofinal;
		resultadofinal = resultado.get(0);
		
		System.out.println(resultadofinal);
		
		double resultadoesperado = 11;
		
		 assertEquals( resultadoesperado , resultadofinal, 0);
		
	}

}
