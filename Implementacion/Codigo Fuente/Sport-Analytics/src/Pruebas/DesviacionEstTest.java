package Pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import SegmentacionTemporal.AlgoritmoSegmentacion;
import SegmentacionTemporal.SegmentadorTemporal;

public class DesviacionEstTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {


			
		ArrayList<Double> pListaPrueba = new ArrayList<Double>();
		
		for (int indice = 0; indice < 10 ; indice++){
			double numerorandom = 2*indice;
			pListaPrueba.add(numerorandom);
			
		}
		
		AlgoritmoSegmentacion video = new SegmentadorTemporal();
		
		/* AQUI PROBAMOS EL METODO CALCULARMEDIA() */
		double media = video.calcularMedia(pListaPrueba);
		
		
		double resultado = video.calcularDesviacion(pListaPrueba, media);
		
		double resultadoesperado = 6.0553007081949835;
		
		/*Verificamos que el calculo de la media esten correctos, con eso comparamos el resultado esperado, con el
		 * resultado obtenido*/
	    assertEquals( resultadoesperado , resultado, 0);
	    
	    
	}

}
