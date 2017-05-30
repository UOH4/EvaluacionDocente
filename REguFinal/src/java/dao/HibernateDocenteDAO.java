/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Docente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateSession;

/**
 *
 * @author Esn
 */
public class HibernateDocenteDAO implements DocenteDAO{

    @Override
    public Docente selectById(int id) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Docente docente =(Docente) session.get(Docente.class, id);
        session.close();
        return docente;
    }

    @Override
    public List<Docente> SelectAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Docente>docente=session.createCriteria(Docente.class).list();
        session.close();
        return docente;
    }

    @Override
    public void insert(Docente docente) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(docente);
        docente.setIdDocente(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Docente docente) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(docente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delate(Docente docente) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(docente);
        session.getTransaction().commit();
        session.close();
    }
    
}
