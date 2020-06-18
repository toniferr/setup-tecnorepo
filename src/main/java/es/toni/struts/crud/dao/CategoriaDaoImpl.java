package es.toni.struts.crud.dao;

import java.util.ArrayList;
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
    private static List<Categoria> categorias;
    
    public Categoria findById(Integer id) {

        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();

        Categoria categoria = null;
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            categoria = (Categoria) session.load(Categoria.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
        return categoria;
    }

    @Override
    public List<Categoria> findAll() {    	
    	
        SessionFactory sessions = HibernateUtil.getSessionFactory();
        Session session = sessions.openSession();
        List<Categoria> categoria = null;
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
            LOG.error("Error : ",e);
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
            e.printStackTrace();
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
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
