package examenes.examen20240130.ej04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import examenes.examen20240130.ej01.Libro;
import hashMap.Articulo;

public class Interfaz {

	public static void main(String[] args) throws ParseException {

		List<Reserva> list = new ArrayList<Reserva>();
		


		for (int i = 0; i < 2 ; i++) {
			Reserva reservaTemp = new Reserva();
			String time = Utils.Arrays.requestString("Introduzca una fecha y hora (dd-MM-yyyy)");
			Date sdf = new SimpleDateFormat ("dd-MM-yyyy").parse(time);
			reservaTemp.getFecha().setTime(sdf);
			list.add(reservaTemp);
			

		}
		
		for (int j = 0; j < list.size(); j++) {
			System.out.println(j +": " +list.get(j).getFecha().getTime());
		}
	}
		
	}


