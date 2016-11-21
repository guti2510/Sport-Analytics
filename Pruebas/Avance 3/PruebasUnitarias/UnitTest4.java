package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import SegmentacionTemporal.AlgoritmoSegmentacion;
import SegmentacionTemporal.SegmentadorTemporal;

public class UnitTest4 {

	static ArrayList<Double> pListaPrueba = new ArrayList<Double>();
	static AlgoritmoSegmentacion video = new SegmentadorTemporal();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		for (int indice = 0; indice < 20 ; indice++){
			double numerorandom = 2*indice/20;
			pListaPrueba.add(numerorandom);			
		}
		
	}

	@Test
	public void test() {
		
		
		/* AQUI PROBAMOS EL METODO CALCULARMEDIA() */
		double resultadofinal = video.calcularMedia(pListaPrueba);
		
		double resultadoesperado = 0.5;
		
		//Verificamos que el calculo de la media este correcto
		
	    assertEquals( resultadoesperado , resultadofinal, 0);
	}

}
