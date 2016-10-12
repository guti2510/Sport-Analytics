package SegmentacionTemporal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class SegmentadorTemporal implements AlgoritmoSegmentacion{
	
	VideoEditor openCvEdit;
	ArrayList<InfoFrame> listaFrame;
	ArrayList<Mat> rawFrame;
	
	public SegmentadorTemporal(){
		openCvEdit = new OpenCVEditor();
		listaFrame = new ArrayList<>();
		rawFrame = new ArrayList<>();
	}
	
	public ArrayList<Double> calcularSimilitudHist(ArrayList<Mat> listaHist){
		double media1, media2, alpha, beta, distancia;
		long tamanoTotal = 1;
		ArrayList<Double> listaDistancia = new ArrayList<>();
		
		//El tamano es 256
		if(listaHist.size() > 0)
			tamanoTotal = listaHist.get(0).total();
		
		for(int cont = 1; cont < listaHist.size(); cont++){
			alpha = 0;
			beta = 0;
			
			/* Calcula alpha */
			
			media1 = Core.mean(listaHist.get(cont -1)).val[0];
			media2 = Core.mean(listaHist.get(cont)).val[0];
							
			alpha =  1 / (Math.sqrt( media1 * media2 * Math.pow(tamanoTotal, 2)) ); 
			
			//System.out.println("a: "+ alpha);

			/* Calcula beta*/
		    
			for(int fila = 0; fila < tamanoTotal; fila++){
				beta = beta + Math.sqrt(listaHist.get(cont - 1).get(fila, 0)[0] * listaHist.get(cont).get(fila, 0)[0]);
			}
			
			//System.out.println("b: " + beta);
			
			/*	Calcula la distancia	*/
						
			distancia = 1 / Math.sqrt(1 - alpha * beta);
			
			//System.out.println("Manual: " + distancia + " - OpenCV: "+ Imgproc.compareHist(listaHist.get(cont - 1), listaHist.get(cont), Imgproc.CV_COMP_BHATTACHARYYA));
			
			listaDistancia.add(distancia);
		}
	
		return listaDistancia;
		    	    
	}
	
	public double calcularMedia(ArrayList<Double> pListaBhata){
		double media = 0.0;
		
		for(int indice = 0; indice < pListaBhata.size(); indice++){
			media += pListaBhata.get(indice);
		}
		
		return media / pListaBhata.size();
	}
	
	public double calcularDesviacion(ArrayList<Double> pListaBhata, double pMedia){
		double sumatoria = 0.0;
		
		for(int indice = 0; indice < pListaBhata.size(); indice++){
			sumatoria += Math.pow((pListaBhata.get(indice) - pMedia), 2);
		}
		
		return Math.sqrt((1.0 / (pListaBhata.size() - 1)) * sumatoria);
		
	}
	
	public void clasificarFrames(ArrayList<Double> pListaBhata){
		double media = 0.0, desviacion = 0.0, sumatoria = 0.0;
		this.listaFrame.clear();
		
		media = calcularMedia(pListaBhata);
		
		desviacion = calcularDesviacion(pListaBhata, media);
		
		/*	Determina si es un corte o no	*/
		int iniFrame = 0;
		boolean estaCorte = (pListaBhata.get(0) >= media + desviacion);
		
		for(int indice = 1; indice < pListaBhata.size(); indice++){
			
			if(pListaBhata.get(indice) >= media + desviacion && !estaCorte) {
				/*	Agrega el No corte	*/
				InfoFrame info = new InfoFrame(iniFrame, indice - 1, "No Corte");
				this.listaFrame.add(info);
				
				iniFrame = indice;
				estaCorte = true;
			}else if (estaCorte){
				/*	Agrega el Corte	*/
				InfoFrame info = new InfoFrame(iniFrame, indice - 1, "Corte");
				this.listaFrame.add(info);
				
				iniFrame = indice;
				estaCorte = false;
				//System.out.println(info.getFrameInicial() + " - " + info.getFrameFinal() + " estado: " + info.getTipoEscena());
				
			}
		}
		
		/*for(int indice = 0; indice < frameCortes.size(); indice++){
			System.out.println(frameCortes.get(indice).getFrameInicial() + " - " + frameCortes.get(indice).getFrameFinal() + " estado: " + frameCortes.get(indice).getTipoEscena());
		}*/
		
		System.out.println("media: " + media + " desviacion: " + desviacion);		
		
	}
	
	public void detectarCortes(String nombrevideo){
		
		this.rawFrame = openCvEdit.obtenerFrames(nombrevideo);
		ArrayList<Mat> listaHist = new ArrayList<>();
	
		for(int indice = 0; indice < rawFrame.size(); indice++){

	    		/*	Transformacion del RGB a HSV	*/
	    	    Mat hsv = new Mat();
	    	    hsv = openCvEdit.transformarHSV(this.rawFrame.get(indice));
	    	      	        
	    	    /*	Separa la capa de H de las demas	*/
	    	    Mat capaH = new Mat();
	    	    capaH = openCvEdit.extraerCapaH(hsv);
	    	    
	    	    /*	Calcula el histograma de la capa H	*/
	    	    Mat histograma = openCvEdit.calcularHistograma(capaH);
	    	    
	    	    /*	Normaliza los histogramas	*/
				for(int fila = 0; fila < histograma.total(); fila++){
					histograma.put(fila, 0, (histograma.get(fila, 0)[0] / capaH.total()));
				}

	    	    listaHist.add(histograma);
	    	    
	    	    //dibujarHistograma(histograma, 800, 800);
	    	}
	    	
    	    ArrayList<Double> listaBhata = calcularSimilitudHist(listaHist);
    	    
    	    clasificarFrames(listaBhata);	
		
		System.out.println("Done");
    	
	}
	
	public ArrayList<Double> buscarCortes(ArrayList<InfoFrame> pLista){
		ArrayList<Double> listaindices = new ArrayList<Double>();
		
		for(int indice = 0; indice < pLista.size(); indice++ ){
			if (pLista.get(indice).getTipoEscena().equals("Cut")){
				listaindices.add((double)pLista.get(indice).getFrameInicial() );
			}
		}
		
		return listaindices;
	}
	
	public InfoReporte validarResultado(ArrayList<InfoFrame> pLista){
		
		ArrayList<Double> listaIndices = buscarCortes(pLista);
		int indiceGround = 0, cantFalPositvos = 0, cantFalNegativos = 0; 

		for(int indice = 0; indice < this.listaFrame.size(); indice++ ){
			
			if (this.listaFrame.get(indice).getTipoEscena() == "Corte"){
				if (this.listaFrame.get(indice).getFrameInicial() > listaIndices.get(indiceGround)){
					cantFalPositvos++;
					
					while( indiceGround < listaIndices.size() && this.listaFrame.get(indice).getFrameInicial() >= listaIndices.get(indiceGround) ){
						indiceGround++;
						cantFalNegativos++;
					}
				}else
					cantFalPositvos++;
			}
		}
		InfoReporte reporte = new InfoReporte(cantFalPositvos, cantFalNegativos, pLista.size());
		
		System.out.println("Cantidad de Falso positivo: " + cantFalPositvos + " Falso negativos: " + cantFalNegativos);
		
		return reporte;
	}
	
	public String generarArchivo(){
		   
		  try {

		    FileWriter file = new FileWriter("CortesDetectados.json");
		     
		    JSONArray lista = new JSONArray();
		     
		    for (int indice = 0; indice< this.listaFrame.size();indice++){
		      
		    	InfoFrame frame = new InfoFrame();
		    	frame = this.listaFrame.get(indice);
		     
		      
		    	JSONObject innerObj = new JSONObject();
		    	innerObj.put("initialFrame",frame.getFrameInicial());
		    	innerObj.put("lastFrame", frame.getFrameFinal());
		    	innerObj.put("eventType", frame.getTipoEscena());
		      
		    	lista.add(innerObj);
		      
		    }
		     
		    JSONObject objetoprincipal = new JSONObject();
		     
		    objetoprincipal.put("data", lista);
		     
		    file.write(objetoprincipal.toJSONString());	     
		     
		    file.flush();
		    file.close();

		    return objetoprincipal.toJSONString();
		    
		    } catch (IOException e) {
		    	//manejar error
		    }
		  
		  	return null;
		 }
	
	public String generarReporte(InfoReporte pReporte){
		if(pReporte == null)
			return null;
		
		JSONArray lista = new JSONArray();
		
    	JSONObject innerObj = new JSONObject();
    	
    	innerObj.put("CantFalsoPositivo", pReporte.getCantFalsoPosivitos());
    	innerObj.put("CantFalsoNegativo", pReporte.getCantFalsosNegativos());
    	innerObj.put("CantFrames", pReporte.getCantFrames());
      
    	lista.add(innerObj);
    	
	    JSONObject objetoprincipal = new JSONObject();
	     
	    objetoprincipal.put("data", lista);
	    
	    return objetoprincipal.toJSONString();   
	}

}
