package examenes.examen20231205baloncesto;

public class Partido {
	private Jugador[] equipoA = new Jugador[5];
	private Jugador[] equipoB = new Jugador[5];
	private Jugador[] ambosEquipos = new Jugador[10];
	public Partido() {
		for (int i = 0; i < equipoA.length; i++) {
			equipoA[i] = new Jugador();
			equipoB[i] = new Jugador();
		}
		int j = 0;
		for (int i = 0; i < equipoA.length; i++) {
			ambosEquipos[j] = equipoA[i];
			j++;
		}
		for(int i = 0; i < equipoB.length; i++) {
			ambosEquipos[j] = equipoB[i];
			j++;
		}
		
		System.out.println();
	}
	
	

	
	public Jugador[] getEquipoA() {
		return equipoA;
	}
	
	public void setEquipoA(Jugador[] newEquipoA) {
		equipoA = newEquipoA;
	}
	
	public Jugador[] getEquipoB() {
		return equipoB;
	}
	
	public void setEquipoB(Jugador[] newEquipoB) {
		equipoB = newEquipoB;
	}
	
	public Jugador[] getAmbosEquipos() {
		return ambosEquipos;
	}
	
	public void setAmbosEquipos(Jugador[] newAmbosEquipos) {
		ambosEquipos = newAmbosEquipos;
	}
	
	public String toString() {
		return equipoA +" : " +equipoB;
		
	}
	
	public void estadisticas() {
		boolean hayCambios = true;
		do {
			 hayCambios = false;
				for (int i = 0; i < ambosEquipos.length-1;  i++) {
					if (ambosEquipos[i].getCanastas() > ambosEquipos[i+1].getCanastas()) {
						hayCambios = true;
						Jugador temp = ambosEquipos[i+1];
						ambosEquipos[i+1] = ambosEquipos[i];
						ambosEquipos[i] = temp;
					}
				}
		} while (hayCambios == true);
	
	
		for (int i = getAmbosEquipos().length-1; i >= 0; i--) {
			System.out.println(getAmbosEquipos()[i]);
		}
	
	}
	
	public void tirar(Jugador[] equipo) {
		int probabilidad = 0;
		for (int i = 0; i < equipo.length; i++) {
			probabilidad = Utils.Arrays.getRandomNumber(0, 100);
			if (equipo[i].getProbAcierto() >= probabilidad) {
				equipo[i].setCanastas(equipo[i].getCanastas()+1);
			}
			else equipo[i].setCanastasFalladas(equipo[i].getCanastasFalladas()+1);
		}
	}
}
