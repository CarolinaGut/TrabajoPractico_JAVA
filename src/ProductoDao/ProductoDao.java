package ProductoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import CategoriaDao.CategoriaDao;
import Modelos.Categoria;
import Modelos.Producto;

public class ProductoDao {
	//esta clase luego se borrará
	private static Statement stmt =null;
	private String sql;
	
	public static void Mostrar() throws SQLException 
	{
		//en este metodo utilizar la clase PRODUCTO que esta en MODELOS
		String sql = "SELECT p.*,c.sector FROM Producto p inner join Categoria c on c.idCategoria = p.idCategoria";
		Producto p = null;
		Categoria c = null;
		try 
		{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("id_prod"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				//crear una categoria (falta)
				c = new Categoria();
				c.setId(rs.getInt("idCategoria"));
				c.setSector(rs.getString("nombreCategoria"));
				p.setIdCategoria(c);
				System.out.println(p.toString());//imprimo los datos
			}
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("No se pudo realizar la consulta");
		}	
	}
	
	public static String findAll() 
	{
		//sql = ProductoDao.findAll();
		//ResultSet rs = stmt.executeQuery(sql);
		// extraer datos
		//ProductoDao.Mostrar(rs);
		
		return "Select * from Producto";	
	}
	
	public static String findAllxNombre (String nombre) 
	{
		//sql = ProductoDao.findAllxNombre("arvejas");
		//ResultSet rs = stmt.executeQuery(sql);
		// extraer datos
		//ProductoDao.Mostrar(rs);
		
		return "Select * from Producto where nombre = "+nombre;
	}
	
	public static String insert(int idProducto, String nombre, double precio,int stock, int idCategoria) 
	{
		return "Insert into Producto (idProducto,nombre,precio,stock,idCategoria) "
				+ "values ("+ idProducto+ "," +nombre+ "," +precio+ "," +idCategoria+")";
	}
	
	public static String get(int id) {
		//sql = ProductoDao.get(532);
		//ResultSet rs = stmt.executeQuery(sql);
		// extraer datos
		//ProductoDao.Mostrar(rs);
		
		return "Select * from Producto where idProducto ="+id;
	}
	
	public static String update(int id, String nombre, double precio, int idCate) 
	{
		//solo quiero cambiar el nombre, por eso solo paso por parametro
		//el valor de NOMB y el resto 0.0 porque espera un double, y 0 porque espera un entero
		
		//sql = ProductoDao.update(502,"CocaCola 3Litros",0.0,0);
		//ResultSet rs = stmt.executeQuery(sql);
		return "Update from Producto set nombre="+nombre+"where idProducto ="+id;
	}
	
	public static String delete(int idProd) 
	{
		/*sql = ProductoDao.delete(533);
		  ResultSet rs = stmt.executeQuery(sql);*/
		
		return "Delete from Producto where idProducto ="+idProd;
	}

}
