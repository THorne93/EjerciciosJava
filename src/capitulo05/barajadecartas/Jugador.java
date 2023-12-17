package capitulo05.barajadecartas;

public class Jugador {
	private String nombre;
	private	Carta[] mano;
	String[] nombrePosible = {
            "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack",
            "Karen", "Leo", "Mia", "Nathan", "Olivia", "Paul", "Quinn", "Rachel", "Sam", "Tina",
            "Ulysses", "Victoria", "Walter", "Xena", "Yasmine", "Zane", "Abigail", "Benjamin", "Chloe", "Daniel",
            "Emily", "Finn", "Giselle", "Harrison", "Isabella", "Jacob", "Kylie", "Liam", "Mila", "Nolan",
            "Olive", "Preston", "Quincy", "Rebecca", "Simon", "Tessa", "Uriah", "Violet", "Wyatt", "Xander"
        };

	public Jugador() {
		nombre= nombrePosible[Utils.Arrays.getRandomNumber(0, nombrePosible.length-1)];
		mano = new Carta[5];
	}
	

	public String getnombre() {
		return nombre;
	}
	
	public void setNombre(String newNombre) {
		nombre = newNombre;
	}
	
	public Carta[] getMano() {
		return mano;
	}
	
	public void setMano(Carta[] newMano) {
		mano = newMano;
	}
	
	public String toString() {
		return nombre + ": " +mano;
		
	}
	
}
