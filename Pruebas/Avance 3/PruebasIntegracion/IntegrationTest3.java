package PruebasIntegracion;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import SegmentacionTemporal.InfoReporte;
import SegmentacionTemporal.SegmentadorTemporal;

public class IntegrationTest3 {

	static InfoReporte pReporte;
	SegmentadorTemporal controlador = new SegmentadorTemporal ();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		int cantidadcortes = 200;
		int cantFalsosPositivos = 100;
		int cantpFalsosNegativos = 20;
		pReporte = new InfoReporte(cantFalsosPositivos,cantpFalsosNegativos,cantidadcortes);

	}

	@Test
	public void test() {
		
		String resultado = controlador.generarReporte(pReporte);
		
		String resultadoesperado = "{\"data\":[{\"CantCortes\":200,\"CantFalsoNegativo\":20,\"CantFalsoPositivo\":100}]}";
		
		assertEquals( resultadoesperado , resultado);
		
	}

}
