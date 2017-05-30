/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HibernateAlumnoDAO;
import dao.HibernateEvaluaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Alumno;
import modelo.Evalua;

/**
 *
 * @author Esn
 */
@ManagedBean
@ViewScoped
public class RevisarEvaluaciones extends Alumno{
    Evalua evaluacion;
    Alumno alumno;
    HibernateEvaluaDAO hibernateEvaluaDAO ;
    HibernateAlumnoDAO hibernateAlumnoDAO;
    public RevisarEvaluaciones() {
        evaluacion = new Evalua();
        alumno = new Alumno();
        hibernateEvaluaDAO = new HibernateEvaluaDAO();
        hibernateAlumnoDAO = new HibernateAlumnoDAO();
    }
    public String checkEvaluaciones(){
        String desicion = "";
        try {
            //Agrego a la variable nombreAlu el objeto det session con el nombre de inicio de secion
            //String nombreAlu = String.valueOf( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("NomUser"));
            /*alumno = hibernateAlumnoDAO.selectNombre(getNombre());
            evaluacion = hibernateEvaluaDAO.selectAlumno(alumno.getIdMatricula());
            if(evaluacion.equals(null)){
                //Sin evaluaciones
                FacesContext.getCurrentInstance().getExternalContext().redirect("evaluacion.xhtml");
            }else{
                //mostrar fecha de evaluacion
                FacesContext.getCurrentInstance().getExternalContext().redirect("evaluaciones.xhtml");
            }*/
            String idAlu = String.valueOf( FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("IdUser"));
            alumno = hibernateAlumnoDAO.selectById(idAlu);
            if(alumno.getEstado() == null){
                desicion = "evaluacion.xhtml";
            }else{
                desicion = "evaluaciones.xhtml";
            }
        } catch (Exception e) {
        }
        return desicion;
    }
}
