/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Docente;

/**
 *
 * @author Esn
 */
public interface DocenteDAO {
    public Docente selectById(int id);
    
    public List<Docente>SelectAll();
    
    public void insert(Docente docente);
    
    public void update(Docente docente);
    
    public void delate(Docente docente);
}
