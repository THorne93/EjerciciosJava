package capitulo08.centroeducativo.entities;

public class Valoracion {
	

	private int id;
	private int idProfesor;
	private int idEstudiante;
	private int idMateria;
	private float valoracion;
	
	public Valoracion(int id, int idProfesor, int idEstudiante, int idMateria, float valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}
	
	public Valoracion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", idProfesor=" + idProfesor + ", idEstudiante=" + idEstudiante + ", idMateria="
				+ idMateria + ", valoracion=" + valoracion + "]";
	}
	
}
