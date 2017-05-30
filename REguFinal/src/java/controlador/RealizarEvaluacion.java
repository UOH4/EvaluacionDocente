/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HibernateAlumnoDAO;
import dao.HibernateDocenteDAO;
import dao.HibernateEvaluaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Alumno;
import modelo.Docente;
import modelo.Evalua;

/**
 *
 * @author Esn
 */
@ManagedBean
@ViewScoped
public class RealizarEvaluacion extends Evalua{
    int i=0;
    Alumno alu;
    Evalua evalua;
    Docente docente;
    HibernateAlumnoDAO aO;
    HibernateEvaluaDAO hibernateEvaluaDAO;
    HibernateDocenteDAO hibernateDocenteDAO;
    public RealizarEvaluacion() {
        alu = new Alumno();
        evalua = new Evalua();
        aO = new HibernateAlumnoDAO();
        hibernateEvaluaDAO = new HibernateEvaluaDAO();
        hibernateDocenteDAO = new HibernateDocenteDAO();
    }
    public String evaluar1(){
        String ruta = "error.xhtml";
        try {
            ruta = "pregunta2.xhtml";
            i = getEvaluacion()+i;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Calificacion",i);
            return ruta;
            
        } catch (Exception e) {
        }
        return ruta;
    }
    public String evaluar2(){
        String ruta = "error.xhtml";
        try {
            ruta = "pregunta3.xhtml";
            i = getEvaluacion()+i;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Calificacion",i);
            return ruta;
        } catch (Exception e) {
        }
        return ruta;
    }
    public String evaluar3(){
        String ruta = "error.xhtml";
        try {
            ruta = "fin.xhtml";
            
            String idAlu = String.valueOf( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("IdUser"));
            alu = aO.selectById(idAlu);
            alu.getIdMatricula();
            alu.getNombre();
            alu.getPass();
            alu.setEstado("Hecho");
            aO.update(alu);
            
            inserEvaluar();
            
            return ruta;
        } catch (Exception e) {
        }
        return ruta;
    }
    public void inserEvaluar(){
        try {
            i = getEvaluacion()+i;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Calificacion",i);
            int califi = Integer.parseInt( String.valueOf( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Calificacion")));
            int result = califi/3;
            String idalu = String.valueOf( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("IdUser"));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = new Date();
            
            alu = aO.selectById(idalu);
            docente = hibernateDocenteDAO.selectById(1);
            alu.getIdMatricula();
            docente.getIdDocente();
            
            evalua.setAlumno(alu);
            evalua.setDocente(docente);
            evalua.setEvaluacion(result);
            evalua.setFecha(fecha);
            hibernateEvaluaDAO.insert(evalua);
        } catch (Exception e) {
        }
    }
}
