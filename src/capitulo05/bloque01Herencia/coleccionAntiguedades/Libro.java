package capitulo05.bloque01Herencia.coleccionAntiguedades;

public class Libro extends Antiguedad {
	
	protected String autor;
	protected String titulo;
	protected String genero;
	
	public Libro() {
		super();
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("origen: " +origen + " ");
		sb.append("año de fabricación: " +anoFabricacion + " ");
		sb.append("autor: " +autor + " ");
		sb.append("titulo: " +titulo + " ");
		sb.append("género: " +genero + " ");	
		sb.append("precio: " +precio + "€ ");
		
		return sb.toString();
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void pideDatos() {
		
		this.nombre = Utils.Arrays.requestString("Escribe el nombre");
		this.anoFabricacion = Utils.Arrays.requestString("Escribe año de fabricación");
		this.origen = Utils.Arrays.requestString("Escribe el origen");
		this.autor = Utils.Arrays.requestString("Escribe el autor");
		this.titulo = Utils.Arrays.requestString("Escribe el titulo");
		this.genero = Utils.Arrays.requestString("Escribe el genero");
		this.precio = Utils.Arrays.requestNumber("Escribe el precio");
	}
	
	

}
