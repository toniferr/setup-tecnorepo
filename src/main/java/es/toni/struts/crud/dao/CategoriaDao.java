package es.toni.struts.crud.dao;

import java.util.List;

import es.toni.struts.crud.model.Categoria;

public interface CategoriaDao {
    
	Categoria findById(Integer id);
	
    List<Categoria> findAll();

	void save(Categoria categoria);
    
    void delete(Categoria categoria);
}
