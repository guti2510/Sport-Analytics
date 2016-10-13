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
		String archvivo = controlador.generarArchivoCortes("src/Video.MP4");
		System.out.println(archvivo);
		
		String reporte = controlador.comprarGround("src/Video.MP4", "Groundtruth.json");
		System.out.println(reporte);

	}

}
