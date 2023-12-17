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
		StringBuffer sb = new StringBuffer();
		
		switch(cartaNumero) {
		case 1:
			sb.append("As");
			break;
		case 11:
			sb.append("J");
			break;
		case 12:
			sb.append("Q");
			break;
		case 13:
			sb.append("K");
			break;
		default:
			sb.append(cartaNumero);
		}
		
		if (cartaPalo.equalsIgnoreCase("Corazones")) sb.append(" de Corazones");
		else if (cartaPalo.equalsIgnoreCase("Picas")) sb.append(" de Picas");
		else if (cartaPalo.equalsIgnoreCase("Diamantes")) sb.append(" de Diamantes");
		else sb.append(" de Tréboles");

		
		return sb.toString();
		
	}
}
