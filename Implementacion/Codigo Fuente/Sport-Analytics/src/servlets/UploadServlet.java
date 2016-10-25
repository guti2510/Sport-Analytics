package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.opencv.core.Core;

import Excepciones.ErrorEditor;
import Excepciones.ErrorJson;
import SegmentacionTemporal.ControladorSegmentador;

/**
 * @author Grupo 5 - Aseguramiento de la Calidad del Software
 * 			-Juan Jose Gutierrez J
 * 			-Alexander Sanchez B
 * 			-Katerine Molina
 *
 */
 
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*50,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
	private String fileName;
	//static{System.loadLibrary("C:\\Users\\Katerine\\Documents\\openCV\\opencv\\build\\java\\x64\\opencv_java2413.dll");}
    /**
     * handles file upload
     * @throws IOException 
     * @throws ServletException 
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
    	System.load("C:\\Users\\Katerine\\Documents\\openCV\\opencv\\build\\java\\x64\\opencv_java2413.dll");
        // gets absolute path of the web application
        //String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = "F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Proyecto_Web\\Sport-Analytics-web\\WebContent\\video" ; // MODIFICAR SI SE CAMBIA DE COMPUTADORA
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        /*Variables utilizadas en los bloques*/
        String filePath ="";
        JSONObject jsResultado;
        String cortes =" ";
        String resultado=null;
        
        /*obtiene los datos del cliente*/
			for (Part part : request.getParts()) {
			    fileName = extractFileName(part);
			    part.write(savePath + File.separator + fileName);
			    filePath = savePath + File.separator + fileName;
			    filePath.replace("\\","\\\\" );
			    break;
			    
			}
			/*Procesar el video cargado*/
			
			ControladorSegmentador controlador = new ControladorSegmentador();
			try {
				cortes = controlador.generarArchivoCortes(filePath);
			} catch (ErrorJson | ErrorEditor e) {
				throw new ServletException(e.getMessage());
			}
			//System.out.println(cortes);(DEBUG)
			
			/* ....... Final de proceso de generación*/
			
			// Procesar el archivo para agregar el nombre del video
			
			try {
				JSONParser parser = new JSONParser();
				jsResultado = (JSONObject) parser.parse(cortes);
				jsResultado.put("video", fileName);
				resultado = jsResultado.toJSONString();
			} catch (ParseException e) {
				throw new ServletException(e.getMessage());
			}
	

			//Envia el JSON
			PrintWriter out = response.getWriter();
		    out.append(resultado);
		    }
        
 
 
    /**
     * Extracts file name from HTTP header content-disposition
     * Extrae el nombre del archivo desde HTTP header content-disposition
     * @param:part / archivo dentro del content-disposition
     * @return String / Nombre del archivo del cliente
     */
    private String extractFileName(Part part) {
    	for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
    	
		return null;
	}
    
    }
