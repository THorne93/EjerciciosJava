package examenes.examen20240130.ej03;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	private static List<WeatherListener> listeners = new ArrayList<WeatherListener>();

	public static void addWeatherListener(WeatherListener l) {
		listeners.add(l);
	}

	public static void removeWeatherListener(WeatherListener l) {
		listeners.remove(l);
	}

	public static void main(String[] args) {

		boolean end = false;
		Juan juan1 = new Juan();
		Donna donna1 = new Donna();
		String tiempo;
		String tiempoTemp = " ";

		do {
				
			tiempo = Utils.Arrays.requestString("Introduzca el tiempo (debe ser “lluvia”, “soleado” y\r\n"
					+ "“nublado”");
			
			System.out.println("El estado del tiempo: " +tiempo);

			if (tiempo.contentEquals("lluvia")) {
				WeatherEvent e = new WeatherEvent();
				e.setWeatherIntroducido(tiempo);
				fireLluvia(e);
			}
			
			if (tiempo.contentEquals("soleado") && tiempoTemp.contentEquals("lluvia")) {
				WeatherEvent e = new WeatherEvent();
				e.setWeatherIntroducido(tiempo);
				fireLluviaAlSol(e);
			}
			
			
			
			tiempoTemp = tiempo;
			} while (end == false);
	}

	

	
	private static void fireLluvia(WeatherEvent e) {
		for (WeatherListener l : listeners) {
			l.lluvia(e);
		}
	}

	private static void fireLluviaAlSol(WeatherEvent e) {
		for (WeatherListener l : listeners) {
			l.lluviaAlSol(e);
		}
	}


}
