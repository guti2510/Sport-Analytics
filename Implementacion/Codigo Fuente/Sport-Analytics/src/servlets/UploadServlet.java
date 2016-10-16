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
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) {
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
         
        String filePath ="";
        try {
			for (Part part : request.getParts()) {
			    fileName = extractFileName(part);
			    part.write(savePath + File.separator + fileName);
			    filePath = savePath + File.separator + fileName;
			    filePath.replace("\\","\\\\" );
			    break;
			    
			}
			/*Procesar el video cargado*/
			String cortes =" ";
			ControladorSegmentador controlador = new ControladorSegmentador();
			cortes = controlador.generarArchivoCortes(filePath);
			System.out.println(cortes);
			/* ....... Final de proceso de generación*/
			
			// Procesar el archivo para agregar el nombre del video
			JSONParser parser = new JSONParser();
			JSONObject jsResultado = (JSONObject) parser.parse(cortes);
	
			jsResultado.put("video", fileName);
			String resultado = jsResultado.toJSONString();
			
			
			//Envia el JSON
			PrintWriter out = response.getWriter();
		    out.append(resultado);
		    
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
 
    /**
     * Extracts file name from HTTP header content-disposition
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
