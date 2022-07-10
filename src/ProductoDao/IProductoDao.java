package ProductoDao;
import java.util.List;

import Modelos.Producto;

public interface IProductoDao {
	
	public List<Producto> findAll();
	
	public Producto findAllxId(int id);
}
