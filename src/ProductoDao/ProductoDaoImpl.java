package ProductoDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelos.Categoria;
import Modelos.Producto;

public class ProductoDaoImpl implements IProductoDao{
	private Statement stmt;
		
	public ProductoDaoImpl(Statement stmt) {
		this.stmt = stmt;
	}

	@Override
	public List<Producto> findAll() {
		Producto p;
		Categoria c;
		List<Producto> lista = new ArrayList<Producto>();
		String sql = "select p.idProducto,p.nombre, p.precio from producto p inner join categoria c on c.idCategoria = p.idcategoria";
		try 
		{
			System.out.println("hola");
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				p = new Producto();
				p.setId(rs.getInt("idProducto"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				//crear una categoria (falta)
				/*c = new Categoria();
				c.setId(rs.getInt("idCategoria"));
				c.setSector(rs.getString("seccion"));
				p.setIdCategoria(c);*/
				lista.add(p);
			}
			rs.close();	
		} 
		catch (SQLException e) {
			System.out.println("error al mostrar todos los datos");
		}
		return lista;
	}

	@Override
	public Producto findAllxId(int id) {
		Producto p = null;
		String sql = "select * from producto p inner join categoria c on c.idCategoria = p.idcategoria where idProducto ="+id;
		ResultSet rs;
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				p = new Producto();
				p.setId(rs.getInt("idProducto"));
				p.setNombre(rs.getString("nombre"));
				p.setPrecio(rs.getDouble("precio"));
				//crear una categoria
				Categoria c = new Categoria();
				c.setId(rs.getInt("idCategoria"));
				c.setSector(rs.getString("sector"));
				//guardo la categoria dentro del producto
				p.setIdCategoria(c);
			}
		} catch (SQLException e) {
			System.out.println("No se encontró el producto");
		}
		
		return p;
	}

}
