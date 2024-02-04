package arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que representa cualquier actor que interviene en el juego
 *
 */
public abstract class Actor {
	// Propiedades protegidas (visibles en la propia clase y en los subtipos) de cada actor
	protected int x, y; // Coordenadas x e y del actor
	; // ancho y alto que ocupa el actor en pantalla
	protected String img; // Imagen del actor
	protected int velocidadX = 0; // Velocidades en cada eje
	protected int velocidadY = 0;
	protected int ancho, alto;
	protected BufferedImage spriteActual;
	protected List<BufferedImage> spritesDeAnimacion = new ArrayList<BufferedImage>();
	protected int velocidadDeCambioDeSprite = 0;
	private int unidadDeTiempo = 0;

	/**
	 * Constructor sin parámetros de entrada
	 */
	public Actor() {
	}

	/**
	 * Constructor con parámetros de entrada
	 * @param x
	 * @param y
	 * @param img
	 */
	public Actor(int x, int y, String img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	/**
	 * Este método abstracto indica que todos los subtipos están obligados a implementarlo. Lo usaremos para pintar cada
	 * personaje.
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}; 
	/**
	 * Método que permite que cada actor realice las acciones que necesite en la creación de cada Frame
	 */
	public void actua () {
		if (this.spritesDeAnimacion != null && this.spritesDeAnimacion.size() > 0) {
			unidadDeTiempo++;
			if (unidadDeTiempo % velocidadDeCambioDeSprite == 0){
				unidadDeTiempo = 0;
				int indiceSpriteActual = spritesDeAnimacion.indexOf(this.spriteActual);
				int indiceSiguienteSprite = (indiceSpriteActual + 1) % spritesDeAnimacion.size();
				this.spriteActual = spritesDeAnimacion.get(indiceSiguienteSprite);
			}
		}
	};
	
	public void colisionaCon(Actor a) {
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	// Getters y setters
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
	public BufferedImage getSpriteActual() {
		return this.spriteActual;
	}

	
	public void setSpriteActual(BufferedImage spriteActual) {
		this.spriteActual = spriteActual;
		this.ancho = this.spriteActual.getWidth();
		this.alto = this.spriteActual.getHeight();
	}
	
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public List<BufferedImage> getSpritesDeAnimacion() {
		return spritesDeAnimacion;
	}

	/**
	 * @param spritesDeAnimacion the spritesDeAnimacion to set
	 */
	public void setSpritesDeAnimacion(List<BufferedImage> spritesDeAnimacion) {
		this.spritesDeAnimacion = spritesDeAnimacion;
	}

	
}
