package es.toni.struts.crud.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import es.toni.struts.crud.model.Categoria;
import es.toni.struts.crud.service.CategoriaService;
import es.toni.struts.crud.service.CategoriaServiceImpl;

public class CategoriaAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(CategoriaAction.class.getName());
	private CategoriaService categoriaService = new CategoriaServiceImpl();
	private Categoria categoria;
	private List<Categoria> categorias;
	
	public CategoriaAction(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@Override
	public void prepare() throws Exception {
		LOG.info("Prepared support data for Categoria entity.");

		if (categoria != null && categoria.getId() != null) {
			categoria = categoriaService.getCategoria(categoria.getId());
			LOG.info("Preparing actual data for Categoria: " + categoria);
		}
	}

	public String list() {
		categorias = categoriaService.getAllCategoria();
		LOG.info("Listing categorias");
		return SUCCESS;
	}

	public String save() {
		if (categoria.getId() == null) {
			categoriaService.insertCategoria(categoria);
			LOG.info("Created new Categoria: " + categoria);
		} else {
			categoriaService.updateCategoria(categoria);
			LOG.info("Updated Categoria: " + categoria);
		}
		return SUCCESS;
	}

	public String delete() {
		categoriaService.deleteCategoria(categoria);
		LOG.info("Deleted Categoria: " + categoria);
		return SUCCESS;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
