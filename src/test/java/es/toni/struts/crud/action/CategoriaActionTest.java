package es.toni.struts.crud.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.toni.struts.crud.model.Categoria;
import es.toni.struts.crud.service.CategoriaService;

public class CategoriaActionTest {

	@Mock
	CategoriaService categoriaService;

	CategoriaAction categoriaAction;

	List<Categoria> listaCategorias = new ArrayList<>();

	Categoria categoria1 = new Categoria();
	Categoria categoria2 = new Categoria();
	Categoria categoria3 = new Categoria();

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		categoriaAction = new CategoriaAction(categoriaService);

		Integer categoria1Id = 1;
		categoria1.setId(categoria1Id);
		categoria1.setNombre("spring");

		Integer categoria2Id = 2;
		categoria2.setId(categoria2Id);
		categoria2.setNombre("struts2");
		
		Integer categoria3Id = 3;
		categoria3.setId(categoria3Id);
		categoria3.setNombre("struts2");

		listaCategorias.add(categoria1);
		listaCategorias.add(categoria2);

	}

	@Test
	public void list() {
		when(categoriaService.getAllCategoria()).thenReturn(listaCategorias);
		categoriaAction.list(); // se ejecuta el método list() del action que redirige SUCCESS y carga
								// listaCategorias llamando a categoriaService.getAllCategoria()
		List<Categoria> listaCategorias = categoriaAction.getCategorias();
		assertFalse(listaCategorias.isEmpty());
		assertEquals(2, listaCategorias.size());
	}

}
