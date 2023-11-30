package capitulo05.barajadecartas;

public class Carta {
		private int cartaNumero;
		private String cartaPalo;
		private int id;
	
	
	public Carta() {
		
	}
	
	public int getCartaNumero() {
		return cartaNumero;
	}
	
	public void setCartaNumero(int newCartaNumero) {
		cartaNumero = newCartaNumero;
	}
	
	public String getCartaPalo() {
		return cartaPalo;
	}
	
	public void setCartaPalo(String newCartaPalo) {
		cartaPalo = newCartaPalo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id = newId;
	}
	
	public String toString() {
		return cartaNumero + " de " +cartaPalo;
		
	}
}
