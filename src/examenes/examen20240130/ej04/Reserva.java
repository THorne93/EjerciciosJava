package examenes.examen20240130.ej04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserva {
	
	private Calendar fecha;
	private String	nombre;
	
	public Reserva() {
		nombre = Utils.Arrays.requestString("Introduzca un nombre");
		fecha = Calendar.getInstance();
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return nombre + " , " +fecha;
		
	}

}
