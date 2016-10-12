package SegmentacionTemporal;

public class InfoFrame {

	private int frameInicial;
	private int frameFinal;
	private String tipoEscena;
	
	public InfoFrame (){}
	
	public InfoFrame (int pFrameInicial, int pFramefinal, String pTipoEscena){
		this.frameInicial = pFrameInicial;
		this.frameFinal = pFramefinal;
		this.tipoEscena = pTipoEscena;
	}
	
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
