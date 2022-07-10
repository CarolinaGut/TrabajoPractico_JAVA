package CategoriaDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDao {
	
	public static void Mostrar(ResultSet rs) throws SQLException
	{
		//en este metodo utilizar la clase: CATEGORIA que esta en MODELOS
		while (rs.next())
		{
			int id = rs.getInt("IdCategoria");
			String seccion = rs.getString("seccion");
			System.out.print("id:"+id);
			System.out.print(", Seccion:" + seccion);
			System.out.println();
		}
	}
	public static String findAll() 
	{
		/*while (rs.next())
		{
			int id = rs.getInt("IdCategoria");
			String seccion = rs.getString("seccion");
			System.out.print("id:"+id);
			System.out.print(", Seccion:" + seccion);
			System.out.println();
		}*/
		return "Select * from Categoria";	
	}
	
	public static String findAllxNombre (String nombreSeccion) 
	{
		//sql = CategoriaDao.findAllxNombre("panaderia");
		//ResultSet rs = stmt.executeQuery(sql);

		// extraer datos
		/*while (rs.next())
		{
			int id = rs.getInt("IdCategoria");
			String seccion = rs.getString("seccion");
			System.out.print("id:"+id);
			System.out.print(", Seccion:" + seccion);
			System.out.println();
		}*/
		return "Select * from Categoria where seccion = "+nombreSeccion;
	}
	
	public static String insert(int IdCategoria, String seccion) 
	{
		//sql = CategoriaDao.insert(9,"jugueteria");
		//ResultSet rs = stmt.executeQuery(sql);
		return "Insert into Categoria (IdCategoria,seccion) "
				+ "values ("+ IdCategoria+ "," +seccion+ ")";
	}
	/*para insertar el prof usaba asi: 
	sql: insert(100, "nuevo", 200, 1 los valores);
	stmt= ExecuteUpdate(sql); 
	return "insert into Jugueteria(...y ahi los nombres de las columnas con +"+"" 
	
	*No se usa el ResultSet.
	*stmt se usa para --delete ---insert----update---*/
	
	
	
	
	public static String get(int id) 
	{
		//sql = CategoriaDao.get(1);
		//ResultSet rs = stmt.executeQuery(sql);

		// extraer datos
		/*while (rs.next())
		{
			int id = rs.getInt("IdCategoria");
			String seccion = rs.getString("seccion");
			System.out.print("id:"+id);
			System.out.print(", Seccion:" + seccion);
			System.out.println();
		}*/
		return "Select * from Categoria where IdCategoria ="+id;
	}
	
	public static String update(int IdCategoria, String seccion) 
	{
		//sql = CategoriaDao.update(5,"CarniceriayEmbutidos");
		//ResultSet rs = stmt.executeQuery(sql);
		return "Update from Categoria set seccion="+seccion+"where IdCategoria ="+IdCategoria;
	}
	
	public static String delete(int idCate) 
	{
		/*sql = CategoriaDao.delete(2);
		  ResultSet rs = stmt.executeQuery(sql);*/
		return "Delete from Categoria where IdCategoria ="+idCate;
	}
}
//






