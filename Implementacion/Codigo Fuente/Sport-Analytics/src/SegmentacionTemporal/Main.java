package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */
import org.opencv.core.Core;

public class Main {

	/*-------- MAIN -------*/
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		ControladorSegmentador controlador = new ControladorSegmentador();
		//String archvivo = controlador.generarArchivoCortes("F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Sport-Analytics\\Implementacion\\Codigo Fuente\\Sport-Analytics\\Video.mp4");
		//System.out.println(archvivo);
		
		String reporte;
		try {
			reporte = controlador.comprarGround("Video.MP4", "Groundtruth.json");
			System.out.println(reporte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
