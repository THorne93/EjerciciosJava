package tresenraya;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class SoundsRepository {
	
	private HashMap<String, AudioClip> sounds = new HashMap<String, AudioClip>();

	private static SoundsRepository instance = null;
	
	private static String RESOURCES_FOLDER = "../tresenraya/resources/sounds/";
	
	
	public static String EFECTO_JUGADOR_1 = "federer.wav";
	public static String EFECTO_JUGADOR_2 = "nadal.wav";
	public static String EFECTO_GANAR = "cheer.wav";
	public static String EFECTO_EMPATAR = "boo.wav";
	
	public SoundsRepository() {
		this.getAudioClip(EFECTO_JUGADOR_1);
		this.getAudioClip(EFECTO_JUGADOR_2);
		this.getAudioClip(EFECTO_GANAR);
		this.getAudioClip(EFECTO_EMPATAR);
	}

	public static SoundsRepository getInstance() {
		if (instance == null) {
			instance = new SoundsRepository();
		}
		return instance;
	}
	
	@SuppressWarnings("removal")
	private AudioClip loadResource(String name) {
		URL url=null;
		url = getClass().getResource(name);
		return Applet.newAudioClip(url);
	}
	
	@SuppressWarnings("removal")
	private AudioClip getAudioClip(String resourceName) {
		
		AudioClip clip = sounds.get(resourceName);
		
		if (clip == null) {
			clip = loadResource(RESOURCES_FOLDER + resourceName);
			sounds.put(resourceName, clip);
		}
		return clip;
	}
	
	public void playSound(final String name) {
		getAudioClip(name).play();
	}
	

}
