package SegmentacionTemporal;


import java.util.ArrayList;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
   
        
public class AperturaVideo {
	
			public Mat TransformacionHSV (Mat frame){
					
					Mat HSV = new Mat();				    
				    Imgproc.cvtColor(frame, HSV, Imgproc.COLOR_RGB2HSV);
					
					return HSV;
			}
	
			
			public Mat ExtracionCapaH (Mat HSV){
				
				ArrayList<Mat> listaHSV = new ArrayList <Mat>();
		        
		        Core.split(HSV, listaHSV);
		        
		        listaHSV.toString();
		        
		        Mat capaH = listaHSV.get(0); 
			
		        return capaH;
			}
			
			public Mat SacarFrame(String nombrevideo){
				
				
				VideoCapture video = new VideoCapture(nombrevideo);
				
				Mat Frame = new Mat();
				if(!video.isOpened()){
		    		System.out.println("Error");
		    	}
		    	else {
		    		
		    	    while(true){
		    	    	if (video.read(Frame)){
		    	    		return Frame;
		    	    	}
		    	    }
		    	}
				return null;
			}
			
			public void CapturarVideo(String nombrevideo){
				
				VideoCapture camera = new VideoCapture(nombrevideo);

				int numeroframe = 0;
				if(!camera.isOpened()){
		    		System.out.println("Error");
		    	}
		    	else {
		    		Mat frame = new Mat();
		    	    while(true){
		    	    	numeroframe +=1;
		    	    	if (camera.read(frame)){
		    	   
		    	    		
		    	    		Highgui.imwrite("Frame.jpg", frame);

		    	    	    /*Esta clase con este metodo hacen la transformacion del RGB a HSV
		    	    	     */
		    	    	    Mat HSV = new Mat();
		    	    	    HSV = TransformacionHSV(frame);
		    	    	    
		    	    	    Highgui.imwrite("HSV.jpg", HSV);
		    	    	    
		    	    	    //Esta clase con este metodo separa la capa de H de las demas
		    	    	    Mat capaH = new Mat();
		    	    	    capaH = ExtracionCapaH(HSV);
		    	            
		    	    	    Highgui.imwrite("capaH.jpg", capaH);
    
		    	    	    break;
		    	    	}
		    	    }	
		    	}
		    	camera.release();
		    	
			}

	}
