package es.toni.struts.crud.model;

public class Categoria implements Cloneable{

	private Integer id;
	
    private String nombre;
    
	public Categoria() {
	}

	public Categoria(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}   
    
	
}
