package capitulo06.bloque02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04 {

	public static void main(String[] args) throws ParseException {
		
		String time = Utils.Arrays.requestString("Introduzca una fecha y hora (dd-MM-yyyy hh:mm:ss)");
		Date sdf = new SimpleDateFormat ("dd-MM-yyyy hh:mm:ss").parse(time);

		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf);
		System.out.println(time);
		System.out.println("\ncon calendar");
		System.out.println("año: " +cal.get(Calendar.YEAR));
		System.out.println("mes: " +cal.get(Calendar.MONTH));
		System.out.println("dia: " +cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("hora: " +cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("minuto: " +cal.get(Calendar.MINUTE));
		System.out.println("segundo: " +cal.get(Calendar.SECOND));


		
		DateFormat ano = new SimpleDateFormat("yyyy");
		DateFormat mes = new SimpleDateFormat("MMM");
		DateFormat dia = new SimpleDateFormat("dd");
		DateFormat hora = new SimpleDateFormat("hh a");
		DateFormat minuto = new SimpleDateFormat("mm");
		DateFormat segundo = new SimpleDateFormat("ss");
		
		String anoDisplay = ano.format(sdf);
		String mesDisplay = mes.format(sdf);
		String diaDisplay = dia.format(sdf);
		String horaDisplay = hora.format(sdf);
		String minutoDisplay = minuto.format(sdf);
		String segundoDisplay = segundo.format(sdf);
		
		System.out.println("\ncon date");
		System.out.println("año: " +anoDisplay);
		System.out.println("mes: " +mesDisplay);
		System.out.println("dia: " +diaDisplay);
		System.out.println("hora: " +horaDisplay);
		System.out.println("minuto: " +minutoDisplay);
		System.out.println("segundo: " +segundoDisplay);

	}

}
