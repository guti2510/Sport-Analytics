package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */

public class InfoFrame {

	private int frameInicial;
	private int frameFinal;
	private String tipoEscena;
	
	/*------- Constructors ----- */
	public InfoFrame (){}
	
	public InfoFrame (int pFrameInicial, int pFramefinal, String pTipoEscena){
		this.frameInicial = pFrameInicial;
		this.frameFinal = pFramefinal;
		this.tipoEscena = pTipoEscena;
	}
	
	/*------ Getters and Setters  ------ */
	public int getFrameInicial() {
		return frameInicial;
	}
	public void setFrameInicial(int frameInicial) {
		this.frameInicial = frameInicial;
	}
	public int getFrameFinal() {
		return frameFinal;
	}
	public void setFrameFinal(int frameFinal) {
		this.frameFinal = frameFinal;
	}
	public String getTipoEscena() {
		return tipoEscena;
	}
	public void setTipoEscena(String tipoEscena) {
		this.tipoEscena = tipoEscena;
	}
}
