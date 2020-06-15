package es.toni.struts.crud.dao;

import es.toni.struts.crud.model.Categoria;

public interface CategoriaDao {
    
    Categoria getCategoria(Integer id);
    
    Categoria[] getAllCategoria();

    void updateCategoria(Categoria categoriaBean);
    
    void insertCategoria(Categoria categoriaBean);
    
    void deleteCategoria(Integer id);
}
