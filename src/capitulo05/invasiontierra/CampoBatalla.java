package capitulo05.invasiontierra;

public class CampoBatalla {
	private String nombre;
	private Humano[] humanos = new Humano[20];
	private Malvado[] malvados = new Malvado[20];
	
	/*
	 * 
	 */
	public CampoBatalla () {
		for (int i = 0; i < humanos.length; i++) {
			humanos[i] = new Humano();
			humanos[i].setNombre("Humano-" +i);
		}
		Humano ultimoHumano = humanos[humanos.length-1];
		ultimoHumano.setPuntosVida(ultimoHumano.getpuntosVida() * 2);

		
		for (int i = 0; i < malvados.length; i++) {
			malvados[i] = new Malvado();
			malvados[i].setNombre("Malvado-" +i);
		}
		
		Malvado ultimoMalvado = malvados[malvados.length-1];
		ultimoMalvado.setPuntosVida(ultimoMalvado.getpuntosVida() * 2);
		
		mezclaHumanos();
		mezclaMalvados();
		
	

	}
	
	
	/**
	 * 
	 * @param humanos
	 */
	public void mezclaHumanos () {
		for (int i = 0; i < humanos.length; i++) {
			int azar1 = Utils.Arrays.getRandomNumber(0, humanos.length-1);
			int azar2 = Utils.Arrays.getRandomNumber(0, humanos.length-1);
			
			Humano aux = humanos[azar1];
			humanos[azar1] = humanos[azar2];
			humanos[azar2] = aux;
		}
	}
	
	/**
	 * 
	 * @param malvados
	 */
	public void mezclaMalvados () {
		for (int i = 0; i < malvados.length; i++) {
			int azar1 = Utils.Arrays.getRandomNumber(0, malvados.length-1);
			int azar2 = Utils.Arrays.getRandomNumber(0, malvados.length-1);
			
			Malvado aux = malvados[azar1];
			malvados[azar1] = malvados[azar2];
			malvados[azar2] = aux;
		}
	}
	
	public Humano getPrimerHumanoVivo () {
		for (int i = 0; i < humanos.length; i++) {
			if (humanos[i].isVivo() == true) {
				return humanos[i];
			}
		}
		
		return null;
	}
	
	public Malvado getPrimerMalvadoVivo () {
		for (int i = 0; i < malvados.length; i++) {
			if (malvados[i].isVivo() == true) {
				return malvados[i];
			}
		}
		
		return null;
	}
	
	public void muestraEstadoActual () {
		for (int i = 0; i < humanos.length; i++) {
			System.out.print(humanos[i] + " - ");
		}
		System.out.println();
		for (int i = 0; i < malvados.length; i++) {
			System.out.print(malvados[i] + " - ");
		}
		System.out.println("\n");
	}
	
}
