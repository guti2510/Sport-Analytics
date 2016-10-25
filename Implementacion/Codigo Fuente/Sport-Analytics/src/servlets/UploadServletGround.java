package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
 *  @version 2.0.0
 */
 
@WebServlet("/UploadServletGround")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*10)   // 50MB
public class UploadServletGround extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Direcciones donde se guardan los arhcivos
     */
    private static final String SAVE_DIR = "uploadFiles";
	private String fileName;
	//static{System.loadLibrary("C:\\Users\\Katerine\\Documents\\openCV\\opencv\\build\\java\\x64\\opencv_java2413.dll");}
    /**
     * Subir un GroundTruth del cliente y compararlo con un video en específico
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws ServletException 
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
    	
    	// Lectura de la librería dll de OpenCV 
    	System.load("C:\\Users\\Katerine\\Documents\\openCV\\opencv\\build\\java\\x64\\opencv_java2413.dll");
        // Dirección donde se guarda
        String savePath = "F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Proyecto_Web\\Sport-Analytics-web\\WebContent\\archivosGround" ; // MODIFICAR SI SE CAMBIA DE COMPUTADORA
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        /*Guardar archivo**/
        String filePath ="";
        try {
			for (Part part : request.getParts()) {
			    fileName = extractFileName(part);
			    part.write(savePath + File.separator + fileName);
			    filePath = savePath + File.separator + fileName;
			    filePath.replace("\\","\\\\" );
			    break;
			    
			}
			/*Comparar el archivo cargado*/
			String comparacion =" ";
			ControladorSegmentador controlador = new ControladorSegmentador();
			System.out.println(fileName);
			String videoPath =  "F:\\Cursos\\II Semestre 2016\\Aseguramiento de software\\Proyectos\\Proyecto_Web\\Sport-Analytics-web\\WebContent\\video\\" ;
			videoPath+=request.getParameter("video");
			
			comparacion = controlador.comprarGround(videoPath, filePath);
			/* ....... Final de proceso de comparacion*/
			
			JSONParser parser = new JSONParser();
			JSONObject jsResultado = (JSONObject) parser.parse(comparacion);
	

			String resultado = jsResultado.toJSONString();
			System.out.println(resultado);

			//Envia el JSON
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
		    out.append(resultado);
		    
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
        
    }
 
    /**
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
