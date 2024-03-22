package capitulo08.centroeducativo.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import capitulo08.centroeducativo.entities.Valoracion;

public class ControllerValoracion extends SuperController {

	private static String nombreTabla = "valoracionmateria";

	public static Valoracion findByIdMateriaAndIdProfesorAndIdEstudiante(int idMateria, int idProfesor,
			int idEstudiante) {

		Valoracion o = null;

		try {
			PreparedStatement ps = ConnectionManager.getConexion().prepareStatement("select * from " + nombreTabla
					+ " where idProfesor = ? and" + " idMateria = ? and idEstudiante = ? limit 1 ");

			ps.setInt(1, idProfesor);
			ps.setInt(2, idMateria);
			ps.setInt(3, idEstudiante);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				o = getEntidadFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}


	private static Valoracion getEntidadFromResultSet(ResultSet rs) throws SQLException {
		Valoracion o = new Valoracion();
		o.setId(rs.getInt("id"));
		o.setIdEstudiante(rs.getInt("idEstudiante"));
		o.setIdMateria(rs.getInt("idMateria"));
		o.setIdProfesor(rs.getInt("idProfesor"));
		o.setValoracion(rs.getFloat("valoracion"));
		return o;
	}


	public static int insercion(Valoracion o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			int nuevoId = nextIdEnTabla("valoracionmateria");
			PreparedStatement ps = conn.prepareStatement("" + "insert into " + nombreTabla
					+ " (id, idProfesor, idEstudiante, idMateria, valoracion) " + " values (?, ?, ?, ?, ?)");

			ps.setInt(1, nuevoId);
			ps.setInt(2, o.getIdProfesor());
			ps.setInt(3, o.getIdEstudiante());
			ps.setInt(4, o.getIdMateria());
			ps.setFloat(5, o.getValoracion());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}


	public static void modificacion(Valoracion o) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("" + "update " + nombreTabla + " set valoracion = ? where id = ? ");

			ps.setFloat(1, o.getValoracion());
			ps.setInt(2, o.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}