package arkanoid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;


public class ResourcesCache {



	private HashMap<String, Object> hmRecursos = new HashMap<String, Object>();
	private String nombreCarpetaParaFile = "./src/arkanoid/resources/";
	private String nombreCarpetaParaURL = "resources/";

	
	
	private static ResourcesCache instance= null;
	
	public static ResourcesCache getInstance () {
		if (instance == null) {
			instance = new ResourcesCache();
		}
		return instance;
	}


	/**
	 * 
	 */
	public void cargarRecursosEnMemoria () {
		File carpeta = new File(nombreCarpetaParaFile);
		for (File fichero : carpeta.listFiles()) {
	        if (fichero.isFile()) {
	        	cargarFicheroEnHashMap(fichero.getName());
	        }
	    }
	}

	
	/**
	 * 
	 * @param nombreFichero
	 */
	private void cargarFicheroEnHashMap (String nombreFichero) {
		// Obtengo un objeto URL para localizar el recurso
		URL url = null;
		url = getClass().getResource(nombreCarpetaParaURL + nombreFichero);
		// Discriminará el caso de que intento cargar un sonido del caso de cargar imágenes
		try {
			if (nombreFichero.endsWith(".wav") || nombreFichero.endsWith(".mp3")) {
				this.hmRecursos.put(nombreFichero, Applet.newAudioClip(url));
			} 
			else { // Si no es un sonido entiendo que se trata de una imagen
				this.hmRecursos.put(nombreFichero, ImageIO.read(url));
			}
		}
		catch (Exception ex) {
			System.out.println("No se pudo cargar el recurso " + nombreFichero);
			ex.printStackTrace();
		}
	}

	
	
	/**
	 * Mediante este método casteamos a imagen el recurso que nos proporciona el supertipo
	 * @param name
	 * @return
	 */
	public BufferedImage getImagen(String nombreFichero) {
		return (BufferedImage) hmRecursos.get(nombreFichero);
	}



	
}
