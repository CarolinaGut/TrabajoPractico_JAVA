package CompraDao;

public class CompraDao {
	
	public static String update(int idCompra, int fecha, int idCliente) 
	{
		//solo quiero cambiar la fecha, por eso solo paso por parametro
		
		//sql = CompraDao.update(76,"2022-06-24",1013);
		//ResultSet rs = stmt.executeQuery(sql);
		return "Update from compra set id="+idCompra+"where idCliente ="+idCliente;
	}
	
	public static String insert(int idCompra, int fecha,int idCliente, int total) 
	{
		return "Insert into compra (idCompra,fecha,idCliente, total) "
				+ "values ("+ idCompra+ "," +fecha+ ","+idCliente+ "," +total+")";
	
		//INSERT INTO compra VALUES ('73', '2022-06-22','1002');
	}
	
	
	

	
	
	
	
	
	
}
