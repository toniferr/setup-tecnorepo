package es.toni.struts.crud.model;

import java.io.Serializable;

public class Miembro  implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
    private String nombre;
    
    private String descripcion;
    
	private Categoria categoria;    

	public Miembro() {
	}

	public Miembro(Integer id, String nombre, String descripcion, Categoria categoria) {		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Miembro [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categoria=" + categoria
				+ "]";
	}
	
}
