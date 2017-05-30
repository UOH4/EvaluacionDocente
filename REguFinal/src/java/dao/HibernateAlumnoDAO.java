/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateSession;

/**
 *
 * @author Esn
 */
public class HibernateAlumnoDAO implements AlumnoDAO{

    @Override
    public Alumno selectById(String id) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Alumno alumno =(Alumno) session.get(Alumno.class, id);
        session.close();
        return alumno;
    }

    @Override
    public List<Alumno> SelectAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Alumno>alumno=session.createCriteria(Alumno.class).list();
        session.close();
        return alumno;
    }

    @Override
    public void insert(Alumno alumno) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //se acomodo para que aseptara cadena
        String id=(String)session.save(alumno);
        alumno.setIdMatricula(id);//id cliente
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Alumno alumno) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(alumno);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delate(Alumno alumno) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(alumno);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Alumno login(Alumno alumno) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
	Transaction tx = null;
        String resultado ="";
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("select estado from alumno where id_matricula = "+alumno.getIdMatricula()+" and pass = "+alumno.getPass());
		 alumno = (Alumno)query.uniqueResult();
                 //resultado = String.valueOf( query.getQueryString());
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return alumno;
    }

    @Override
    public Alumno selectNombre(String nom) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        Alumno a = new Alumno();
	Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("select * from alumno where nombre = '" + nom +"'");
		 a = (Alumno)query.uniqueResult();
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return a;
    }
    
}
