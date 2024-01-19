package capitulo06.bloque02;

import java.util.Calendar;
import java.util.TimeZone;

public class Ex05 {

	public static void main(String[] args) {

			Calendar horaRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
			Calendar horaWashington = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
			long milis = (horaRoma.getTimeInMillis()-horaWashington.getTimeInMillis());
			long horas = milis/1000;
			System.out.println("Hora en Roma: " +horaRoma.get(Calendar.HOUR_OF_DAY));
			System.out.println("Hora en Washington: " +horaWashington.get(Calendar.HOUR_OF_DAY));
			System.out.println("Diferencia entre ellos: " +(horaRoma.get(Calendar.HOUR_OF_DAY)-horaWashington.get(Calendar.HOUR_OF_DAY)));
	}

}
