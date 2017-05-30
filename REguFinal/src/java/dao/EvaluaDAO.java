/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Evalua;

/**
 *
 * @author Esn
 */
public interface EvaluaDAO {
    public Evalua selectById(int id);
    
    public Evalua selectAlumno(String idAlu);
    
    public List<Evalua>SelectAll();
    
    public void insert(Evalua evalua);
    
    public void update(Evalua evalua);
    
    public void delate(Evalua evalua);
}
