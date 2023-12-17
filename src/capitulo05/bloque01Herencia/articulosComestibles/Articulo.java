package capitulo05.bloque01Herencia.articulosComestibles;

public class Articulo {

		protected String nombre;
		protected String codigo;
		protected int precio;
		
		
		public Articulo() {
			
		}
		
		public String toString() {
			
			StringBuffer sb = new StringBuffer();
			sb.append("nombre: " +nombre + " ");
			sb.append("precio: " +precio + "€ ");
			sb.append("codigo: " +codigo + " ");
			
			
			return sb.toString();
		}
		
		public String getNombre() {
		return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
		

}
