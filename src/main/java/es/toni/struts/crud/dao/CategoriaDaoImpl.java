package es.toni.struts.crud.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import es.toni.struts.crud.model.Categoria;
import es.toni.struts.crud.util.HibernateUtil;

public class CategoriaDaoImpl implements CategoriaDao {
	
    private static final Logger LOG = LogManager.getLogger(CategoriaDaoImpl.class.getName());
    private List<Categoria> categorias;
    private Categoria categoria;
    
    public Categoria findById(Long id) {

        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            categoria = (Categoria) session.get(Categoria.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("Error en método findById : ", e);
        } finally {
            session.close();
        }
        return categoria;
    }

    @Override
    public List<Categoria> findAll() {    	
    	
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Categoria");
            categorias =  query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("Error en el método findAll : ",e);
        } finally {
            session.close();
        }
        return categorias;
    }

    @Override
    public void save(Categoria categoria) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(categoria);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("Error en el método save : ",e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Categoria categoria) {
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(categoria);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("Error en el método delete : ",e);
        } finally {
            session.close();
        }
    }
}
