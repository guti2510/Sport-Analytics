package SegmentacionTemporal;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

public class OpenCVEditor implements VideoEditor{
	
	public OpenCVEditor(){}

	public Mat transformarHSV (Mat frame){
		
		Mat HSV = new Mat();				    
	    Imgproc.cvtColor(frame, HSV, Imgproc.COLOR_RGB2HSV);
	    
		return HSV;
	}
	
	
	public Mat extraerCapaH (Mat HSV){
		
		ArrayList<Mat> listaHSV = new ArrayList <Mat>();
	    
	    Core.split(HSV, listaHSV);
	    
	    listaHSV.toString();
	    
	    Mat capaH = listaHSV.get(0); 
	    
	    /* Normaliza la capa H	*/
	    Core.normalize(capaH, capaH, 0, 255, Core.NORM_MINMAX);
	    
	    return capaH;
	}
	
	public ArrayList<Mat> obtenerFrames(String nombrevideo){
		
		ArrayList<Mat> listaFrames = new ArrayList<>();
		VideoCapture video = new VideoCapture(nombrevideo);
		
		
		if(!video.isOpened()){
			System.out.println("Error: abriendo el video");
		} else {
			
	    		Mat frame = new Mat();
	    		
    	    	while (video.read(frame)){
    	    	
    	    		Mat frameleido = frame.clone();
    	    		listaFrames.add(frameleido);
    	    	}
			
		}
		
		return listaFrames;
	}
	
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
	
	private void dibujarHistograma(Mat histograma, int resHorizontal, int resVertical){
		
		MatOfInt cubetas = new MatOfInt(256); // 256 cubetas
		int tamanoCubeta = (int) Math.round(resHorizontal / cubetas.get(0, 0)[0]);
		
		Mat imagen = new Mat(resVertical, resHorizontal, CvType.CV_8UC3, new Scalar(0, 0, 0));
		
		// normalizar el resultado de [0, histImage.rows()]
		Core.normalize(histograma, histograma, 0, imagen.rows(), Core.NORM_MINMAX, -1, new Mat());
	    
		for (int i = 1; i < cubetas.get(0, 0)[0]; i++)
		{
			Core.line(imagen, new Point(tamanoCubeta * (i - 1), resVertical - Math.round(histograma.get(i - 1, 0)[0])),
					new Point(tamanoCubeta * (i), resVertical - Math.round(histograma.get(i, 0)[0])), new Scalar(255, 0, 0), 2, 8, 0);
		}
		
		Highgui.imwrite("HistFrame.png", imagen);
	}
}
