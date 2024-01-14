package arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


/**
 * Clase que representa un player en el juego
 *
 */
public class Nave extends Actor {
	public static String IMAGEN_PLAYER = "paddle.gif";
	private boolean izquierda = false, derecha = false;
	public static int VELOCIDAD = 5;
	protected int ancho = 100, alto = 30;

	/**
	 * Constructor por defecto "default constructor"
	 */
	public Nave() {
		super();
		ancho = 200;
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Nave(int x, int y, String img) {
		super(x, y, img);
		this.velocidadX = 0;
		this.velocidadY = 0;
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
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
	
		if (izquierda) this.x -= VELOCIDAD;
		if (derecha) this.x += VELOCIDAD;
		mover(this.x);

	}

	public void mover(int x) {
		this.x = x;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MiCanvas canvas = Arkanoid.getInstance().getCanvas(); // Referencia al objeto Canvas usado
		
		// Compruebo si el jugador sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		// Compruebo si el jugador sale por la izquierda
		if (this.x < 0) {
			this.x = 0;
		}
		
		// Compruebo si el jugador sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}
		
		// Compruebo si el jugador sale por arriba
		if (this.y < 0) {
			this.y = 0;
		}
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
		}
	}
	
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:

		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
}
