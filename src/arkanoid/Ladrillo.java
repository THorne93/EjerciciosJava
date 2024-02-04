package arkanoid;

import java.awt.Color;
import java.awt.Graphics;




public class Ladrillo extends Actor {

	//Propiedades estáticas de esta clase
	public static String IMAGEN_PLAYER = "nave.gif";
	protected int ancho = 50, alto = 30;
	protected int puntosVida;
	protected String[] coloresEspecial = {"plateado","dorado"};


	/**
	 * Constructor por defecto "default constructor"
	 */
	public Ladrillo() {
		super();
		puntosVida = Utils.Arrays.getRandomNumber(1, 3);

	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Ladrillo(int x, int y, String img) {
		super(x, y, img);
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Player
	 */
	public String toString() {
		return "Player [getX()=" + getX() + ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}


	public String[] getColoresEspecial() {
		return coloresEspecial;
	}

	public void setColoresEspecial(String[] coloresEspecial) {
		this.coloresEspecial = coloresEspecial;
	}

	/**
	 * Utilizado para pintar un player, según sus coordenadas de x e y
	 */
	@Override
	public void paint(Graphics g) {
		if (getPuntosVida() == 1) {
			g.setColor(Color.WHITE);
		}
		else if (getPuntosVida() == 2) {
			g.setColor(Color.BLUE);
		}
		else g.setColor(Color.GREEN);
		
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
	
	}

	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		 if (a instanceof Pelota) {
			 if (getPuntosVida() == 1) {
			        Arkanoid.getInstance().eliminaActor(this);
					Arkanoid.getInstance().incorporaNuevoActor(new Explosion(this.x, this.y));

			 }
			 else setPuntosVida(getPuntosVida()-1);
			 
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
