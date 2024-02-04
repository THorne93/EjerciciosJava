package arkanoid;

import java.awt.Color;
import java.awt.Graphics;



public class Pelota extends Actor {

	//Propiedades estáticas de esta clase
	public static String IMAGEN_PLAYER = "nave.gif";
	private int velocidadX = -5;
	private int velocidadY = -5;
	protected int ancho = 30, alto = 30;

	/**
	 * Constructor por defecto "default constructor"
	 */
	public Pelota() {
		super();
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Pelota(int x, int y, String img) {
		super(x, y, img);
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Player
	 */
	public String toString() {
		return "Player [getX()=" + getX() + ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

	/**
	 * Utilizado para pintar un player, según sus coordenadas de x e y
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
		// El monstruo se mueve de manera horizontal, en cada FPS
		this.x += this.velocidadX;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velocidadX = -this.velocidadX;
		}
		
		// Copiamos el esquema anterior para el movimiento vertical
		this.y += this.velocidadY;
		// Si el monstruo abandona la escena por la izquierda o la derecha, rebota
		if (this.y < 0 || (this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
			this.velocidadY = -this.velocidadY;
		}
		
	}

	@Override
	public void colisionaCon(Actor a) {
	    super.colisionaCon(a);
	    
	    if (a instanceof Nave || a instanceof Ladrillo) {
	        this.velocidadY = -this.velocidadY; 
	        actua();
	    }
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


	
}
