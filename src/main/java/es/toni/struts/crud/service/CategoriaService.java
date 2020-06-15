package es.toni.struts.crud.service;

import es.toni.struts.crud.model.Categoria;

public interface CategoriaService {

	Categoria getCategoria(Integer id);

	Categoria[] getAllCategoria();

	void updateCategoria(Categoria categoria);

	void insertCategoria(Categoria categoriaBean);

	void deleteCategoria(Integer id);

}