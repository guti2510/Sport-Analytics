package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import SegmentacionTemporal.AlgoritmoSegmentacion;
import SegmentacionTemporal.SegmentadorTemporal;

public class UnitTest3 {

	static ArrayList<Double> listaPrueba = new ArrayList<Double>();
	static AlgoritmoSegmentacion video = new SegmentadorTemporal();
	static double media;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		for (int indice = 0; indice < 20 ; indice++){
			double numero = 2*indice/20;
			listaPrueba.add(numero);
			
		}
		

		media = video.calcularMedia(listaPrueba);
		
		
	}

	@Test
	public void test() {
		
	
		
		//Probamos el metodo calcularDesviacion
		double resultadofinal = video.calcularDesviacion(listaPrueba, media);
		
		
		double resultadoesperado = 0.512989176042577;
		
		//Verificamos que el calculo de la desviacion este correcto
	    assertEquals( resultadoesperado , resultadofinal, 0);
	}

}
