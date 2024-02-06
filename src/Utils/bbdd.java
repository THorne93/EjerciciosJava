package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import capitulo08.bloque01.JDBCPropiedades;


public class bbdd {

	
	
	public static Connection getConexion() 
			throws ClassNotFoundException, SQLException {
		
		String driver = JDBCPropiedades.getProperty("JDBC_DRIVER_CLASS");
		String user = JDBCPropiedades.getProperty("JDBC_USER");
		String password = JDBCPropiedades.getProperty("JDBC_PASSWORD");
		String host = JDBCPropiedades.getProperty("JDBC_HOST");
		String schema = JDBCPropiedades.getProperty("JDBC_SCHEMA_NAME");
		String properties = JDBCPropiedades.getProperty("JDBC_PROPERTIES");

		Class.forName(driver);

		return (Connection) DriverManager.getConnection ("jdbc:mysql://" + host + "/" + schema + properties, user, password);
	}
}
