package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */

public class InfoReporte {
	private int cantFalsoPosivitos;
	private int cantFalsosNegativos;
	private int cantFrames;
	
	/*------- Constructor ----- */
	public InfoReporte(int pFalsoPosivitos, int pFalsosNegativos, int pFrames){
		this.cantFalsoPosivitos = pFalsoPosivitos;
		this.cantFalsosNegativos = pFalsosNegativos;
		this.cantFrames = pFrames;
	}
	
	/*------ Getters and Setters  ------ */
	public int getCantFalsoPosivitos() {
		return cantFalsoPosivitos;
	}
	public void setCantFalsoPosivitos(int cantFalsoPosivitos) {
		this.cantFalsoPosivitos = cantFalsoPosivitos;
	}
	public int getCantFalsosNegativos() {
		return cantFalsosNegativos;
	}
	public void setCantFalsosNegativos(int cantFalsosNegativos) {
		this.cantFalsosNegativos = cantFalsosNegativos;
	}
	public int getCantFrames() {
		return cantFrames;
	}
	public void setCantFrames(int cantFrames) {
		this.cantFrames = cantFrames;
	}
	

}
