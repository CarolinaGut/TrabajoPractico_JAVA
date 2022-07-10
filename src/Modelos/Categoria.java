package Modelos;

public class Categoria {
 
	private int id;
	private String sector;
	
	//constructor
	public Categoria(int id, String sector) {
		super();
		this.id = id;
		this.sector = sector;
	}

	public Categoria() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", sector=" + sector + "]";
	}
	
	
	
}
