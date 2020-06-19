package es.toni.struts.crud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.toni.struts.crud.dao.CategoriaDao;
import es.toni.struts.crud.model.Categoria;

public class CategoriaServiceTest {
    
    @Mock
    CategoriaDao categoriaDao;

    CategoriaService categoriaService;

    List<Categoria> listaCategorias = new ArrayList<>();
    
    Categoria categoria1 = new Categoria();
    Categoria categoria2 = new Categoria();
    Categoria categoria3 = new Categoria();

	Long categoria1Id = 1L;
	Long categoria2Id = 2L;
	Long categoria3Id = 3L;
    
    @Before
    public void setUp() {

		MockitoAnnotations.initMocks(this);
		categoriaService = new CategoriaServiceImpl(categoriaDao);
		
    	categoria1.setId(categoria1Id);
    	categoria1.setNombre("spring");
    	
    	categoria2.setId(categoria2Id);
    	categoria2.setNombre("struts2");
    	
    	categoria3.setId(categoria3Id);
    	categoria3.setNombre("jsf");
    	
    	listaCategorias.add(categoria1);
    	listaCategorias.add(categoria2);
    	listaCategorias.add(categoria3);
    }
    
    @Test
    public void  getAllCategoria() {
		when(categoriaDao.findAll()).thenReturn(listaCategorias);
		List<Categoria> listaCategorias = categoriaService.getAllCategoria();
		assertFalse(listaCategorias.isEmpty());
		assertEquals(3, listaCategorias.size());    	
    }

    @Test
    public void findById() {
        when(categoriaDao.findById(anyLong())).thenReturn(categoria1);
        Categoria categoria= categoriaService.getCategoria(categoria1Id);
        assertEquals("spring", categoria.getNombre());
    }
}
