package examenes.examen20231205baloncesto;

public class Jugador {
	private String nombre;
	private int canastas;
	private int probAcierto;
	private int canastasFalladas;
	
	String[] nombrePosible = {
            "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack",
            "Karen", "Leo", "Mia", "Nathan", "Olivia", "Paul", "Quinn", "Rachel", "Sam", "Tina",
            "Ulysses", "Victoria", "Walter", "Xena", "Yasmine", "Zane", "Abigail", "Benjamin", "Chloe", "Daniel",
            "Emily", "Finn", "Giselle", "Harrison", "Isabella", "Jacob", "Kylie", "Liam", "Mila", "Nolan",
            "Olive", "Preston", "Quincy", "Rebecca", "Simon", "Tessa", "Uriah", "Violet", "Wyatt", "Xander"
        };
	
	public Jugador() {
		nombre= nombrePosible[Utils.Arrays.getRandomNumber(0, nombrePosible.length-1)];
		canastas = 0;
		canastasFalladas = 0;
		probAcierto = Utils.Arrays.getRandomNumber(20, 100);
	}
	
	public String getnombre() {
		return nombre;
	}
	
	public void setNombre(String newNombre) {
		nombre = newNombre;
	}
	
	public int getCanastas() {
		return canastas;
	}
	
	public void setCanastas(int newCanastas) {
		canastas = newCanastas;
	}
	
	public int getProbAcierto() {
		return probAcierto;
	}
	
	public void setProbAcierto(int newProbAcierto) {
		probAcierto = newProbAcierto;
	}
	
	public int getCanastasFalladas() {
		return canastasFalladas;
	}
	
	public void setCanastasFalladas(int newCanastasFalladas) {
		canastasFalladas = newCanastasFalladas;
	}
	
	public String toString() {
		return nombre + ", ProbAcierto: " +probAcierto + ", canastas: " +canastas + ", no canastas: " +canastasFalladas;
		
	}
}
