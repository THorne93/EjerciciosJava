package examenes.examen20240130.ej01;

public class Libro {
	private String autor;
	private String titulo;
	
	public Libro() {
		
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String toString() {
		return titulo + " : " +autor;
	}
}
