package SegmentacionTemporal;

/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */

import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

import Excepciones.ErrorEditor;

public class OpenCVEditor implements VideoEditor{
	
	public OpenCVEditor(){}

	/**
	 * Recibe un Mat que es un frame del video, y realiza la transformacion del
	 * color RGB a HSV, y retorna un Mat con el calculo. 
	 *
	 * @param  		frame - Un Mat que es un frame del video.
	 * @return      HSV - Una Mat con el calculo de la transformacion de color
	*/
	public Mat transformarHSV (Mat frame){
		
		Mat HSV = new Mat();				    
	    Imgproc.cvtColor(frame, HSV, Imgproc.COLOR_RGB2HSV);
	    
		return HSV;
	}
	
	/**
	 * Recibe un Mat que es un frame del video, y realiza la extraccion de la capa H
	 * del HSV
	 *
	 * @param  		HSV - Un Mat que es un frame del video (Con el HSV).
	 * @return      capaH - Una Mat con la capa extraida del HSV
	*/
	public Mat extraerCapaH (Mat HSV){
		
		ArrayList<Mat> listaHSV = new ArrayList <Mat>();
	    
	    Core.split(HSV, listaHSV);
	    
	    listaHSV.toString();
	    
	    Mat capaH = listaHSV.get(0); 
	    
	    /* Normaliza la capa H	*/
	    Core.normalize(capaH, capaH, 0, 255, Core.NORM_MINMAX);
	    
	    return capaH;
	}
	
	/**
	 * Realiza la detección de frames del video completo y lo guarda en una
	 * lista de tipo Mat
	 *
	 * @param  		nombrevideo - Un string con el nombre del video.
	 * @return  ArrayList<Mat>  matriz con los frames obtenidos. 
	 * @throws ErrorEditor 
	*/
	public ArrayList<Mat> obtenerFrames(String nombrevideo) throws ErrorEditor{
		
		ArrayList<Mat> listaFrames = new ArrayList<>();
		VideoCapture video = new VideoCapture(nombrevideo);
		
		try{
		if(!video.isOpened()){
			throw new Exception("Error abriendo el video");
		} else {
			
	    		Mat frame = new Mat();
	    		
    	    	while (video.read(frame)){
    	    	
    	    		Mat frameleido = frame.clone();
    	    		listaFrames.add(frameleido);
    	    	}
			
		}
		
		return listaFrames;
		}
		catch(Exception e){
			throw new ErrorEditor(e.getMessage());
		} 
	}
	
	/**
	 * Realiza el calculo de los histogramas de cada uno de los cuadros 
	 * usando únicamente la capa H de los frames.
	 *
	 * @param  		matriz - Un Mat con la capa H del frame.
	 * @return      histograma - Un Mat con el calculo del histograma.
	*/
	public Mat calcularHistograma (Mat matriz){
	    
	    ArrayList<Mat> listaHSV = new ArrayList <Mat>();		        
        listaHSV.add(matriz);
        
		//cubetas 256
		MatOfInt cubetas = new MatOfInt(256);
		//canal 1
		MatOfInt canales = new MatOfInt(0);
		//rango 256
		MatOfFloat rango = new MatOfFloat(0, 255);
	    
		//Histograma
		Mat histograma = new Mat();
	    
	    Imgproc.calcHist(listaHSV, canales, new Mat(), histograma, cubetas, rango, false);
	    
	    return histograma;
	}
	
}
