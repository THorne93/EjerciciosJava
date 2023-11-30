package capitulo05.arkanoid;

public class Ladrillo {
	private String nombre;
	private String color;
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int puntosVida;
	private boolean vivo;
	
	public Ladrillo() {
		x = Utils.Arrays.getRandomNumber(0, 800);
		y = Utils.Arrays.getRandomNumber(0, 500);
		ancho = 100;
		alto = 50;
		puntosVida = Utils.Arrays.getRandomNumber(1, 3);
		vivo = true;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String newColor) {
		color = newColor;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int newAncho) {
		ancho = newAncho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int newAlto) {
		alto = newAlto;
	}
	
	public int getPuntosVida() {
		return puntosVida;
	}
	
	public void setPuntosVida(int newPuntosVida) {
		puntosVida = newPuntosVida;
	}
	public boolean isVivo () {
		return vivo;
	}
	public void setVivo(boolean newVivo) {
		vivo = newVivo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String newNombre) {
		nombre = newNombre;
	}
	
	public String toString() {
		return nombre+ ":" +color+ ":" + x + ":" +y + ":" +ancho + ":" +alto + ":" +puntosVida + ":" +vivo;
		
	}
	
	public void quitaPuntos() {
		puntosVida -= 1;
		if (puntosVida == 0) {
			vivo = false;
		}
	}
}


