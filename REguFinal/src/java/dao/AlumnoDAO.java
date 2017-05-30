/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Alumno;

/**
 *
 * @author Esn
 */
public interface AlumnoDAO {
    public Alumno selectById(String id);
    
    public Alumno login(Alumno alumno);
    
    public Alumno selectNombre(String nom);
    
    public List<Alumno>SelectAll();
    
    public void insert(Alumno alumno);
    
    public void update(Alumno alumno);
    
    public void delate(Alumno alumno);
}
