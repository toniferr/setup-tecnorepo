package es.toni.struts.crud.service;

import java.util.List;

import es.toni.struts.crud.model.Categoria;

public interface CategoriaService {

	Categoria getCategoria(Long id);

	List<Categoria> getAllCategoria();

	void updateCategoria(Categoria categoria);

	void insertCategoria(Categoria categoria);

	void deleteCategoria(Categoria categoria);

}