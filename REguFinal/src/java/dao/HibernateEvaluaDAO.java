/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Evalua;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateSession;

/**
 *
 * @author Esn
 */
public class HibernateEvaluaDAO implements EvaluaDAO{

    @Override
    public Evalua selectById(int id) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Evalua evalua =(Evalua) session.get(Evalua.class, id);
        session.close();
        return evalua;
    }

    @Override
    public List<Evalua> SelectAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Evalua>evalua=session.createCriteria(Evalua.class).list();
        session.close();
        return evalua;
    }

    @Override
    public void insert(Evalua evalua) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int id=(int)session.save(evalua);
        evalua.setIdEvaluacion(id); //id cliente
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Evalua evalua) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(evalua);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delate(Evalua evalua) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(evalua);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Evalua selectAlumno(String idAlu) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Evalua e = new Evalua();
	Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("select * from evalua where id_fk_matricula = " + idAlu);
		 e = (Evalua)query.uniqueResult();
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return e;
    }
    
}
