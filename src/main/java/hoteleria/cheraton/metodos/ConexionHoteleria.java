package hoteleria.cheraton.metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexionHoteleria {
	
	private static Connection conexion; 
	private static Statement s;
	private static ResultSet rs;
	
	public static List<String> listaDeFotosPorIdHabitacion(String idHabitacion)
	{
		List<String> listaFotos = new ArrayList<String>();
		try {
			conexion = DriverManager.getConnection ("jdbc:mysql://localhost/hoteleria2","root", "Xpoter19");
			s = conexion.createStatement();
			rs = s.executeQuery ("CALL buscarFotosPorIdHabitacion('"+idHabitacion+"')");
			
			while (rs.next())
			{
				listaFotos.add(rs.getString(1));
			}
			
			rs.close();
			s.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaFotos;				
	}
}
