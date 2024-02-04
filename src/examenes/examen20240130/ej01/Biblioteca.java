package examenes.examen20240130.ej01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import hashMap.Articulo;

public class Biblioteca {

	private HashMap<String, Libro> hm = new HashMap<String, Libro>();
	private List<Libro> list = new ArrayList<Libro>();

	
	
	public Biblioteca() {
		
		Libro libroTemp = new Libro();
		libroTemp.setAutor("Jose");
		libroTemp.setTitulo("Mi coche favorito");
		hm.put("Mi coche favorito", libroTemp);
		
		Libro libroTemp2 = new Libro();
		libroTemp2.setAutor("Juanita");
		libroTemp2.setTitulo("Vivir en el mar");
		hm.put("Vivir en el mar", libroTemp2);
		
		Libro libroTemp3 = new Libro();
		libroTemp3.setAutor("Paco");
		libroTemp3.setTitulo("Yo soy perro");
		hm.put("Yo soy perro", libroTemp3);
		
	}
	
	public void showList(HashMap<String, Libro> hm) {
		
		Iterator<Libro> libros = hm.values().iterator();
		while (libros.hasNext()) {
			System.out.println(libros.next());
		}
		
	}
	
	public void prestarLibro(HashMap<String, Libro> hm, List<Libro> list) {
		System.out.println("\nLibros disponible:");
		showList(hm);
		String input = Utils.Arrays.requestString("Introducir el nombre del libro:");
		list.add(hm.get(input));
		hm.remove(input);
		
	}


	public HashMap<String, Libro> getHm() {
		return hm;
	}


	public void setHm(HashMap<String, Libro> hm) {
		this.hm = hm;
	}


	public List<Libro> getList() {
		return list;
	}


	public void setList(List<Libro> list) {
		this.list = list;
	}

	public void devolverLibro(HashMap<String, Libro> hm2, List<Libro> list2) {
		System.out.println("\nLibros prestados:");
		for (int j = 0; j < list.size(); j++) {
			System.out.println(j +": " +list.get(j));
		}
		String input = Utils.Arrays.requestString("Introducir el numero del libro:");

		for (int i = 0; i < list.size(); i++) {
			if (input.contentEquals(list.get(i).getTitulo())) {
				Libro libroTemp = new Libro();
				libroTemp.setTitulo(list.get(i).getTitulo());
				libroTemp.setAutor(list.get(i).getAutor());
				hm.put(libroTemp.getTitulo(), libroTemp);
				list.remove(i);
			}
			
		}
		


		
	}
	
	
}
