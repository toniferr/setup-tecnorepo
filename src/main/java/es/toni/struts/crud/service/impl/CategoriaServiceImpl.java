package es.toni.struts.crud.service.impl;

import java.util.List;

import es.toni.struts.crud.dao.CategoriaDao;
import es.toni.struts.crud.dao.impl.CategoriaDaoImpl;
import es.toni.struts.crud.model.Categoria;
import es.toni.struts.crud.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {
	
    CategoriaDao categoriaDao = new CategoriaDaoImpl();
    
    public CategoriaServiceImpl() {
	}

    public CategoriaServiceImpl(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
    public Categoria getCategoria(Integer id) {
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
