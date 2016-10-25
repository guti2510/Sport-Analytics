package SegmentacionTemporal;
/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 * @version 2.0.0
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Excepciones.ErrorJson;

public class LecturaArchivo {
	
	/**
	 * Lee un archivo tipo .json el cual es el groundtruth, y guarda la informacion de este archivo en una
	 * lista de clases de tipo InfoFrame.
	 * 
	 * @param  	 pNombreGroud - Un string con el nombre del archivo de groundtruth
	 * @return   ListaFrames - Una lista de clases de tipo InfoFrame con los datos del groundtruth
	 * @throws ErrorJson 
	 * 
	*/
	public ArrayList<InfoFrame> leerArchivo(String pNombreGroud) throws IOException, ParseException, ErrorJson{
		
		ArrayList<InfoFrame> ListaFrames = new ArrayList<InfoFrame>();
		
        try {
			FileReader reader = new FileReader(pNombreGroud);
			
			JSONObject json = (JSONObject) new JSONParser().parse(reader);
			
			/*Hacemos un Array del bloque de data*/
			JSONArray lang = (JSONArray) json.get("data");
			
			/*Creamos un ciclo para recolectar la informacion de cada bloque dentro del data*/
			for(int i = 1; i<lang.size(); i++){
				
				JSONObject jsonObjectRow = (JSONObject) lang.get(i);
				
				/*Obtenemos el frame inicial, frame final y el tipo de evento*/
	            long frameinicial = (long) jsonObjectRow.get("initialFrame");
	            long framefinal = (long) jsonObjectRow.get("lastFrame");
	            String tipoevento = (String) jsonObjectRow.get("eventType");
				
	            /*Creamos la clase con la informacion obtenida */
	            InfoFrame frame = new InfoFrame((int)frameinicial,(int)framefinal,tipoevento);
	            
	            /*Ingresamos la clase a una lista*/
	            ListaFrames.add(frame);
	            
			}
	
			
		} catch (Exception e) {
			throw new ErrorJson("Archivo no encontrado o erróneo");
		}
        
        
        return ListaFrames;
	}

}
