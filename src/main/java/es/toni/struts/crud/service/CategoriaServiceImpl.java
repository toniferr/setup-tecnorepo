package es.toni.struts.crud.service;

import java.util.List;

import es.toni.struts.crud.dao.CategoriaDao;
import es.toni.struts.crud.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {
	
    CategoriaDao categoriaDao; 
    
    public CategoriaServiceImpl() {
	}

    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
    public Categoria getCategoria(Long id) {
        return categoriaDao.findById(id);
    }

    @Override
    public List<Categoria> getAllCategoria() {
        return categoriaDao.findAll();
    }

    @Override
    public void updateCategoria(Categoria categoria) {
    	categoriaDao.save(categoria);
    }

    @Override
    public void insertCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void deleteCategoria(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

}
