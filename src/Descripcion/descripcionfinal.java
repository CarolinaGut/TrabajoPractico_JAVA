package Descripcion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class descripcionfinal {

	public static void MostrarD (ResultSet rs) throws SQLException 
	{
		
		while (rs.next())
		{
			int id = rs.getInt("Idventa");
			Double precio = rs.getDouble("precio");
			int idP= rs.getInt("IdProducto");
			int idC= rs.getInt("IdCompra");
			
			System.out.print("Idventa:"+id);
			System.out.println();
			System.out.println("corresponde a la compra: "+ idC);
			System.out.println();
			System.out.println("contiene: "+ idP+ "a:$ "+precio);
		}
	}
	
	
	
	
	
	
}
