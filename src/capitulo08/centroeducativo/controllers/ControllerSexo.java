package capitulo08.centroeducativo.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import capitulo08.centroeducativo.entities.Sexo;

public class ControllerSexo {

	private static String nombreTabla = "centroeducativo.tipologiaSexo";

	
	public static List<Sexo> getTodos() {
		List<Sexo> l = new ArrayList<Sexo>();
		
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("Select * from " + nombreTabla);
			while (rs.next()) {
				Sexo o = getEntidadFromResultSet(rs);
				l.add(o);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;		
	}
	
	private static Sexo getEntidadFromResultSet (ResultSet rs) throws SQLException {
		Sexo o = new Sexo();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));

		return o;
	}
}
