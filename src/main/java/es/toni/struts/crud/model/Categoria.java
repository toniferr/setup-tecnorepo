package es.toni.struts.crud.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String nombre;
	
	private Categoria categoria_padre;
    
	private Set<Categoria> categorias =
			new HashSet<Categoria>(0);
	
	private Set<Miembro> miembros =
				new HashSet<Miembro>(0);
    
	public Categoria() {
	}

	public Categoria(Long id, String nombre, Set<Categoria> categorias, Set<Miembro> miembros,
			Categoria categoria_padre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categorias = categorias;
		this.miembros = miembros;
		this.categoria_padre = categoria_padre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Miembro> getMiembros() {
		return miembros;
	}

	public void setMiembros(Set<Miembro> miembros) {
		this.miembros = miembros;
	}

	public Categoria getCategoria_padre() {
		return categoria_padre;
	}

	public void setCategoria_padre(Categoria categoria_padre) {
		this.categoria_padre = categoria_padre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre +"]";
	}
}
