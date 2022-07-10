package TrabajoFinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import CategoriaDao.CategoriaDao;
import Conexion.Conexion;
import Modelos.Producto;
import ProductoDao.IProductoDao;
import ProductoDao.ProductoDao;
import ProductoDao.ProductoDaoImpl;
import ClienteDao.ClienteDao;
import CompraDao.CompraDao;

public class Principal {
	public static int opcion, opcionP;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] arg){
		Connection conn;
		Statement stmt = null;
		
		try {
			//registrar el driver
			Class.forName(Conexion.JDBC_DRIVER);
			//abrir la conexion
			System.out.println("conectando con Base de Datos: Supermark");
			conn = DriverManager.getConnection(Conexion.DB_URL,Conexion.USER,Conexion.PASS);
			//Ejecutar consulta sql
			System.out.println("***Creando Statement***");
			stmt = conn.createStatement();
						
			IProductoDao productoServicios = new ProductoDaoImpl(stmt);
			//--------------MENU---------------------------------------------
			/*menu principal----
			-1 categoria -2productos -3cliente---4Descripcion 5Compra--
			--si elijo productos que aparezcan las opciones o los metodos-
			mostrar, findAll, findAllxNombre,get, insert, update,

			el video del prof es 
			https://www.youtube.com/watch?v=jMLBWy4tn5Y&t=4569s*/

			String respuesta;
			do {
				menuPrincipal();
				switch(opcion) {
				case 1: //categorias
					break;
				case 2: //productos
					menuProductos();
					switch(opcionP) {
					case 1: //mostrar todos
						productoServicios.findAll();
						break;
					case 2: //obtener por id
						Producto prod = productoServicios.findAllxId(1);
						if (prod != null) {
							System.out.println(prod.toString());
						}
						else {
							System.out.println("No hay productos con ese id");
						}
						break;
					}
					
				case 3: break;
				//default: break;
				}
				sc.nextLine();
				System.out.println("Desea continuar SI o NO");
				respuesta = sc.nextLine();
			}
			while(respuesta.toUpperCase().equals("SI"));
			//-----------------------------------------------------------
			
			//cerrar conexiones
			//rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("error al conectar");
		}
		System.out.println("**fin**");
		
	}
	
	public static void menuPrincipal()
	{
		System.out.println("******** menu principal *********");
		System.out.println("******** 1: Categorias **********");
		System.out.println("******** 2: Productos ***********");
		System.out.print("Ingrese una opcion del menu principal");
		opcion = sc.nextInt();
	}
	
	public static void menuCategorias()
	{
		System.out.println("******** Categorias *************");
		System.out.println("******** 1: Mostrar todos *******");
		System.out.println("******** 2: Obtener Id **********");
		System.out.println("******** 3: Alta ****************");
		System.out.println("******** 4: Modificar ***********");
		System.out.println("******** 5: Eliminar ************");
		System.out.println("******* ingrese una opcion ******");
		int opcion = sc.nextInt();
	}
	
	public static void menuProductos()
	{
		System.out.println("******** Productos **************");
		System.out.println("******** 1: Mostrar todos *******");
		System.out.println("******** 2: Obtener Id **********");
		System.out.println("******** 3: Alta ****************");
		System.out.println("******** 4: Modificar ***********");
		System.out.println("******** 5: Eliminar ************");
		System.out.println("******* ingrese una opcion:");
		opcionP = sc.nextInt();		
	}
	}
