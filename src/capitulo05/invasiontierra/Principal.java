package capitulo05.invasiontierra;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CampoBatalla campo = new CampoBatalla();
		
		campo.mezclaHumanos();
		campo.mezclaMalvados();
		
		campo.muestraEstadoActual();
		
		do {
			if (campo.getPrimerHumanoVivo() != null) {
				campo.getPrimerMalvadoVivo().recibirDisparo();
			}
			
			if (campo.getPrimerMalvadoVivo() != null) {
				campo.getPrimerHumanoVivo().recibirDisparo();
			}
			
			campo.muestraEstadoActual();
			
		} while (campo.getPrimerHumanoVivo() != null && campo.getPrimerMalvadoVivo() != null);
		
		if (campo.getPrimerHumanoVivo() != null) {
			System.out.println("Ha ganado los humanos!");
		}
		else if (campo.getPrimerMalvadoVivo() != null) {
			System.out.println("Ha ganado los malvados!");
		}
	}
	
	private static void pausaEjercucion() {
		
	}

}
