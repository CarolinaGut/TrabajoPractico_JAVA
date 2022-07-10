package ClienteDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDao {
	
	//no sale el insert
	public static String insert(int idCliente, String nombre, String apellido, String direccion) 
	{
		return "INSERT INTO cliente (idCliente, nombre, apellido, direccion) VALUES (´"+ idCliente + "´, ´" +nombre+ "´, ´"+ apellido+ "', '"+direccion+"´)";
				 
		//"'INSERT INTO cliente (idCliente,nombre,apellido,direccion) VALUES '"
		//+ ("," + idCliente+ ", "+nombre+ ", " +apellido+ ", "+direccion );
	

	}
	
	public static String get(int id) 
	{
		//sql = ClienteDao.get(1004);
		//ResultSet rs = stmt.executeQuery(sql);

		// extraer datos
		/*while (rs.next())
		{
			int id = rs.getInt("idCliente");
			System.out.print("id:"+id);
			System.out.println();
			
		}*/
		return "Select * from cliente where idCliente ="+ id;
	}	
	
	
	
	
	
	
	
}
