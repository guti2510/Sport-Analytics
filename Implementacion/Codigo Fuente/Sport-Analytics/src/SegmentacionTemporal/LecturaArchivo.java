package SegmentacionTemporal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LecturaArchivo {
	
	public ArrayList<InfoFrame> leerArchivo(String pNombreGroud) throws IOException, ParseException{
		
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
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return ListaFrames;
	}

}
