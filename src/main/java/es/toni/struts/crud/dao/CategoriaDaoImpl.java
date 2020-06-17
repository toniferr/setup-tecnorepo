package es.toni.struts.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import es.toni.struts.crud.model.Categoria;
import es.toni.struts.crud.util.HibernateUtil;

public class CategoriaDaoImpl implements CategoriaDao {
	
    private static final Logger LOG = LogManager.getLogger(CategoriaDaoImpl.class.getName());
    private static final List<Categoria> categorias;

    static {
        categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "Spring"));
        categorias.add(new Categoria(2, "Struts2"));
    }

    @Override
    public Categoria getCategoria(Integer id) {
        for (Categoria p : categorias) {
            if (p.getId().equals(id)) {
                try {
                    return (Categoria) p.clone();
                } catch (CloneNotSupportedException ex) {
                    LOG.error("Unexpected exception cloning Categoria");
                }
            }
        }
        return null;
    }

    @Override
    public List<Categoria> getAllCategoria() {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Categoria> categoria = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Categoria");
            categoria =  query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("Error : ",e);
        } finally {
            session.close();
        }
        return categoria;
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        Integer id = categoria.getId();
        for (int i = 0; i < categorias.size(); i++) {
            Categoria p = categorias.get(i);
            if (p.getId().equals(id)) {
                categorias.set(i, categoria);
                break;
            }
        }
    }

    @Override
    public void insertCategoria(Categoria categoria) {
        int lastId = 0;
        for (Categoria p : categorias) {
            if (p.getId() > lastId) {
                lastId = p.getId();
            }
        }
        categoria.setId(lastId + 1);
        categorias.add(categoria);
    }

    @Override
    public void deleteCategoria(Integer id) {
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            if (categoria.getId().equals(id)) {
                categorias.remove(i);
                break;
            }
        }
    }
}
