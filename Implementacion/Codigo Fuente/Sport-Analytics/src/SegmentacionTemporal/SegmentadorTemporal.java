package SegmentacionTemporal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import Excepciones.ErrorEditor;
import Excepciones.ErrorJson;


/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */
public class SegmentadorTemporal implements AlgoritmoSegmentacion{
	
	VideoEditor openCvEdit;
	ArrayList<InfoFrame> listaFrame;
	ArrayList<Mat> rawFrame;
	
	public SegmentadorTemporal(){
		openCvEdit = new OpenCVEditor();
		listaFrame = new ArrayList<>();
		rawFrame = new ArrayList<>();
	}
	
	/**
	 * Toma una lista de histogramas y calcula la desimilitud entre estos, y retorna
	 * un arreglo de numeros double con los resultados  
	 *
	 * @param  		listaHist - Una lista de histogramas
	 * @return      listaDistancia - Una lista con las comparaciones de similitud 
	 * 								 de histogramas
	*/
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


			/* Calcula beta*/
			for(int fila = 0; fila < tamanoTotal; fila++){
				beta = beta + Math.sqrt(listaHist.get(cont - 1).get(fila, 0)[0] * listaHist.get(cont).get(fila, 0)[0]);
			}
			
			
			/*	Calcula la distancia	*/		
			distancia = 1 / Math.sqrt(1 - alpha * beta);
			
			listaDistancia.add(distancia);
		}
	
		return listaDistancia;
		    	    
	}
	
	/**
	 * Calcula la media de la lista con los calculos de dedisimilitud, y retorna
	 * un numero double con el calculo de la media.
	 *
	 * @param  		pListaBhata - Una lista de numeros double (Calculos de desimilitud)
	 * @return      media - Un numero double con el calculo de la media
	*/
	public double calcularMedia(ArrayList<Double> pListaBhata){
		double media = 0.0;
		
		for(int indice = 0; indice < pListaBhata.size(); indice++){
			media += pListaBhata.get(indice);
		}
		
		return media / pListaBhata.size();
	}
	
	/**
	 * Calcula la desviacion estandar de la lista con los calculos de dedisimilitud, y retorna
	 * un numero double con el calculo de la desviacion estandar.
	 *
	 * @param  	 pListaBhata - Una lista de numeros double (Calculos de desimilitud)
	 * @param  	 pMedia - Un numero double (Calculo de la media)
	 * @return   Un numero double con el calculo de la desviacion estandar
	*/
	public double calcularDesviacion(ArrayList<Double> pListaBhata, double pMedia){
		double sumatoria = 0.0;
		
		for(int indice = 0; indice < pListaBhata.size(); indice++){
			sumatoria += Math.pow((pListaBhata.get(indice) - pMedia), 2);
		}
		
		return Math.sqrt((1.0 / (pListaBhata.size() - 1)) * sumatoria);
		
	}
	
	/**
	 * Determina segun una lista de arrays(Calculos de desimilitud) si se dan cortes o no cortes
	 * en un determinado frame del video.
	 * 
	 * @param  	 pListaBhata - Una lista de numeros double (Calculos de desimilitud)
	 * @return   NA
	*/
	public void clasificarFrames(ArrayList<Double> pListaBhata){
		double media = 0.0, desviacion = 0.0;
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
				
			}
		}
		
		
		System.out.println("media: " + media + " desviacion: " + desviacion);		
		
	}
	
	/**
	 * Obtiene los frames de un video y hace las funcionalidades de transformar los colores 
	 * RGB a HSV, extraer la capa H, calcular los histogramas, y normalizar los histogramas, y
	 * va creando una lista con los histogramas normalizados.
	 * 
	 * @param  	 nombrevideo - Un string con el nombre del video
	 * @throws ErrorEditor 
	*/
	public void detectarCortes(String nombrevideo) throws ErrorEditor{
		
		try {
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
			
			//System.out.println("Done");
		} catch (ErrorEditor e) {
			throw e;
		}
		
    	
	}
	
	/**
	 * Busca en una lista de frames detectados en el groundtruth, cuales poseen la
	 * escena de "Cut" y retorna una lista con numeros double de los frames que
	 * son corte.
	 * 
	 * @param  	 pLista - Una lista de clases de tipo InfoFrame, que contienen la informacion
	 * 					  de los frames detectados en el groundtruth
	 * @return   listaindices - Una lista de numeros double, que son los frames que son cortes
	*/
	public ArrayList<Double> buscarCortes(ArrayList<InfoFrame> pLista){
		ArrayList<Double> listaindices = new ArrayList<Double>();
		
		for(int indice = 0; indice < pLista.size(); indice++ ){
			if (pLista.get(indice).getTipoEscena().equals("Cut")){
				listaindices.add((double)pLista.get(indice).getFrameInicial() );
			}
		}
		
		return listaindices;
	}
	
	/**
	 * Realiza los calculos de los falsos positivos y negativos encontrados en la deteccion de
	 * cortes del video.
	 * 
	 * @param  	 pLista - Una lista de clases de tipo InfoFrame, que contienen la informacion
	 * 					  de los frames detectados en el groundtruth
	 * @return   reporte - Una clase de tipo InfoReporte
	*/
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
		
		//System.out.println("Cantidad de Falso positivo: " + cantFalPositvos + " Falso negativos: " + cantFalNegativos);
		
		return reporte;
	}
	
	/**
	 * Genera un archivo de tipo .json de groundtruth donde se especifque en que cuadros hay un corte,
	 * segun el analisis realizado al video.
	 * 
	 * @return   El retorno es null, ya que solo crear el archivo con la informacion.
	 * @throws ErrorJson 
	*/
	public String generarArchivo() throws ErrorJson{
		   
		  try {

		    FileWriter file = new FileWriter(new File("F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Sport-Analytics\\Implementacion\\Codigo Fuente\\Sport-Analytics\\WebContent\\cortesGenerados","CortesDetectados.json"));
		     
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
		    	e.printStackTrace();
		    	throw new ErrorJson("Error abriendo en la generación de archivo JSON");
		    }
		 }
	
	
	/**
	 * Genera un archivo tipo .json con el reporte con los falsos positivos y negativos encontrados 
	 * en la deteccion de cortes del video.
	 * 
	 * @param  	 pReporte - Una clase de tipo InfoReporte que contiene la informacion de las detecciones
	 * 						realizadas al video
	 * @return   String - Una string con el nombre del archivo generado
	*/
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
