package examenes.examen20231205baloncesto;

import examenes.examen20240130.ej03.Partido;

public class Principal {

	public static void main(String[] args) {
		Partido partido = new Partido();
		
		for (int i = 0; i < 10; i++) {
			partido.tirar(partido.getEquipoA());
			partido.tirar(partido.getEquipoB());
		}
		
		partido.estadisticas();
		
		System.out.println();

		
	}
	
	
}
