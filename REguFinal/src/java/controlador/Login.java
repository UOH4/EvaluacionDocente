/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AlumnoDAO;
import dao.HibernateAlumnoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Alumno;

/**
 *
 * @author Esn
 */
@ManagedBean
@ViewScoped
public class Login extends Alumno{

    private Alumno a ;//= new Alumno();
    HibernateAlumnoDAO aO ;//= new HibernateAlumnoDAO();
    
    public Login() {
        aO = new HibernateAlumnoDAO();
        a = new Alumno();
    }
    public void electId(){
        try {
            //extraer los datos
            a = aO.selectById(getIdMatricula());
            //comparar los datos que obtengo de la BD con los obtendos de jsf
            if(a.equals(null)){
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }else{
                if(a.getPass().equals(getPass())){
                String nom = a.getNombre();
                String id = a.getIdMatricula();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NomUser", nom);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("IdUser", id);
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
                }else{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
                
            }
        } catch (Exception e) {
        }
    }
}
